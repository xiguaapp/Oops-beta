package com.example.vueboot.controller;


import com.example.vueboot.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.Map;

@Controller
public class ImgUploadController  {

    @Autowired
    OssUtil ossUtil;  //注入OssUtil


    @ResponseBody
    @PostMapping("/ups")
    public String sz(@RequestParam("file") MultipartFile file){
        System.out.println("文件"+file);
       return "133";
    }

    @ResponseBody
    @PostMapping("/up")
    public Map fileUpload(@RequestParam("file") MultipartFile file)
        {
        System.out.println("file文件:"+file);
        try {
            String url = ossUtil.uploadFile(file); //调用OSS工具类
            Map<String, Object> returnbody = new HashMap<>();
            Map<String, Object> returnMap = new HashMap<>();
            returnMap.put("url", url);
            returnbody.put("data",returnMap);
            returnbody.put("code","200");
            returnbody.put("message","上传成功");
            return returnbody;
        }
        catch (Exception e) {
            Map<String, Object> returnbody = new HashMap<>();
            returnbody.put("data",null);
            returnbody.put("code","400");
            returnbody.put("message","上传失败");
            return  returnbody;
        }
    }
}
