package com.hooview.common.code;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther lee
 * @createTime 2018年01月18日 16时09分
 * @discription
 */
@Component
public class MobileCode {

    //查账户信息的http地址
    private static String URI_GET_USER_INFO =
            "https://sms.yunpian.com/v2/user/get.json";

    //智能匹配模板发送接口的http地址
    private static String URI_SEND_SMS =
            "https://sms.yunpian.com/v2/sms/single_send.json";

    //模板发送接口的http地址
    private static String URI_TPL_SEND_SMS =
            "https://sms.yunpian.com/v2/sms/tpl_single_send.json";

    //发送语音验证码接口的http地址
    private static String URI_SEND_VOICE =
            "https://voice.yunpian.com/v2/voice/send.json";

    //绑定主叫、被叫关系的接口http地址
    private static String URI_SEND_BIND =
            "https://call.yunpian.com/v2/call/bind.json";

    //解绑主叫、被叫关系的接口http地址
    private static String URI_SEND_UNBIND =
            "https://call.yunpian.com/v2/call/unbind.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";

    //云片apikey
    @Value("${yunpian.apikey}")
    private String apikey;

    //登录短信模板id
    @Value("${yunpian.login_tpl_id}")
    private String login_tpl_id;

    //修改密码短信模板id
    @Value("${yunpian.updatepw_tpl_id}")
    private String updatepw_tpl_id;



    /**
     * 取账户信息
     *
     * @return json格式字符串
     * @throws java.io.IOException
     */

    public static String getUserInfo(String apikey) throws IOException,
            URISyntaxException {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        return post(URI_GET_USER_INFO, params);
    }

    /**
     * 智能匹配模板接口发短信
     *
     * @param apikey apikey
     * @param text   　短信内容
     * @param mobile 　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public String sendSms(String apikey, String text,
                                 String mobile) throws IOException {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_SEND_SMS, params);
    }

    /**
     * 通过模板发送短信(登录)
     *
     * @param mobile    　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public String sendSmsByLogin(String code,
                                    String mobile) throws IOException {
        return sendSmsByTpl(code,mobile,this.login_tpl_id);
    }

    /**
     * 通过模板发送短信(修改密码)
     *
     * @param mobile    　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public String sendSmsByUpPw(String code,String mobile) throws IOException {
        return sendSmsByTpl(code,mobile,updatepw_tpl_id);
    }

    private  String sendSmsByTpl(String code, String mobile,String tpl_id) throws UnsupportedEncodingException {
        String tpl_value = URLEncoder.encode("#code#", ENCODING) + "=" +
                URLEncoder.encode(code, ENCODING);
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("tpl_id", tpl_id);
        params.put("tpl_value", tpl_value);
        params.put("mobile", mobile);
        return post(URI_TPL_SEND_SMS, params);
    }

    /**
     * 通过接口发送语音验证码
     * @param apikey apikey
     * @param mobile 接收的手机号
     * @param code   验证码
     * @return
     */

    public static String sendVoice(String apikey, String mobile, String code) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("mobile", mobile);
        params.put("code", code);
        return post(URI_SEND_VOICE, params);
    }

    /**
     * 通过接口绑定主被叫号码
     * @param apikey apikey
     * @param from 主叫
     * @param to   被叫
     * @param duration 有效时长，单位：秒
     * @return
     */

    public static String bindCall(String apikey, String from, String to,
                                  Integer duration) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("from", from);
        params.put("to", to);
        params.put("duration", String.valueOf(duration));
        return post(URI_SEND_BIND, params);
    }

    /**
     * 通过接口解绑绑定主被叫号码
     * @param apikey apikey
     * @param from 主叫
     * @param to   被叫
     * @return
     */
    public static String unbindCall(String apikey, String from, String to) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("apikey", apikey);
        params.put("from", from);
        params.put("to", to);
        return post(URI_SEND_UNBIND, params);
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map < String, String > paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List< NameValuePair > paramList = new ArrayList<NameValuePair>();
                for (Map.Entry < String, String > param: paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                            param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList,
                        ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, ENCODING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}

