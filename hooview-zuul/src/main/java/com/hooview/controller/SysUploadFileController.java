package com.hooview.controller;

import com.hooview.common.aliyunoss.OSSClientUtil;
import com.hooview.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @auther lee
 * @createTime 2018年01月26日 11时18分
 * @discription
 */
@RestController
public class SysUploadFileController {

    @Autowired
    OSSClientUtil ossClientUtil;

    @RequestMapping(value = "/api/file/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> ImgUpload(HttpServletRequest request, MultipartFile file,int type) {
        String fileName = file.getOriginalFilename();
        if (file == null || file.getSize() <= 0) {
            return R.error(1,"文件为空");
        }
        if(fileName.contains(".jpg") || fileName.contains(".png") || fileName.contains(".bmp") || fileName.contains(".gif")
                || fileName.contains(".jpeg")){
            if (file.getSize() > 1024 * 1024 * 4) {
                return R.error(1,"上传图片大小不能超过4M");
            }
        }
        String fileUrl = null;
        try {
            fileUrl = ossClientUtil.uploadImg2Oss(file,type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.ok().put("fileUrl",fileUrl);
    }
}
