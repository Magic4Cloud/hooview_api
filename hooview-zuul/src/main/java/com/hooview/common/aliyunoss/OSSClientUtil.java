package com.hooview.common.aliyunoss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * @auther lee
 * @createTime 2018年01月26日 10时54分
 * @discription
 */
@Component
public class OSSClientUtil {
    @Value("${aliyunoss.endpoint}")
    private String endpoint;

    @Value("${aliyunoss.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyunoss.accessKeySecret}")
    private String accessKeySecret;

    @Value("${aliyunoss.bucketNameHeader}")
    private String bucketNameHeader;

    @Value("${aliyunoss.bucketNameBanner}")
    private String bucketNameBanner;

    @Value("${aliyunoss.bucketLaunchlive}")
    private String bucketLaunchlive;

    //文件存储目录
    private String filedir = "pic/";

    private OSSClient ossClient;



    public String uploadImg2Oss(MultipartFile file,int type) throws Exception {
        if(ossClient==null){
            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();
        String fileUrl = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            InputStream inputStream = file.getInputStream();
            this.uploadFile2OSS(inputStream, fileUrl,type);
        } catch (Exception e) {
            throw new Exception("图片上传失败");
        }
        if (!StringUtils.isEmpty(fileUrl)) {
            String[] split = fileUrl.split("/");
            return this.getUrl(this.filedir + split[split.length - 1],type);
        }
        return null;
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(String fileUrl) {

        return null;
    }

    /**
     * 上传到OSS服务器  如果同名文件会覆盖服务器上的
     *
     * @param instream 文件流
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFile2OSS(InputStream instream, String fileName,int type) {
        String ret = "";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            String bucketName = null;
            if(type==1) {
                bucketName = bucketNameBanner;
            }else if(type==2){
                bucketName = bucketNameHeader;
            }else if(type==3){
                bucketName = bucketLaunchlive;
            }else {
                return null;
            }
            //上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key,int type) {
        // 设置URL过期时间为50年  3600l* 1000*24*365*50
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 50);
        // 生成URL
        String bucketName = null;
        if(type==1) {
            bucketName = bucketNameBanner;
        }else if(type==2){
            bucketName = bucketNameHeader;
        }else {
            return null;
        }
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }
}

