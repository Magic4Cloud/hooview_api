package com.hooview.common.easemob;

import com.google.gson.Gson;
import io.swagger.client.ApiException;
import io.swagger.client.api.AuthenticationApi;
import io.swagger.client.model.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by easemob on 2017/3/14.
 */
@Component
public class TokenUtil {

    @Value("${easemob.grant_type}")
    public String GRANT_TYPE;

    @Value("${easemob.client_id}")
    public String CLIENT_ID;

    @Value("${easemob.client_sectet}")
    public String CLIENT_SECRET;

    @Value("${easemob.org_name}")
    public String ORG_NAME;

    @Value("${easemob.app_name}")
    public String APP_NAME;

    private static Token BODY;
    private static AuthenticationApi API = new AuthenticationApi();
    private static String ACCESS_TOKEN;
    private static Double EXPIREDAT = -1D;
    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);


    public void initTokenByProp() {
        String resp = null;
        try {
            BODY = new Token().clientId(CLIENT_ID).grantType(GRANT_TYPE).clientSecret(CLIENT_SECRET);
            resp = API.orgNameAppNameTokenPost(ORG_NAME,APP_NAME, BODY);
        } catch (ApiException e) {
            logger.error(e.getMessage());
        }
        Gson gson = new Gson();
        Map map = gson.fromJson(resp, Map.class);
        ACCESS_TOKEN = " Bearer " + map.get("access_token");
        EXPIREDAT = System.currentTimeMillis() + (Double) map.get("expires_in");
    }

    /**
     * get Token from memory
     *
     * @return
     */
    public String getAccessToken() {
        if (ACCESS_TOKEN == null || isExpired()) {
            initTokenByProp();
        }
        return ACCESS_TOKEN;
    }

    private static Boolean isExpired() {
        return System.currentTimeMillis() > EXPIREDAT;
    }

}

