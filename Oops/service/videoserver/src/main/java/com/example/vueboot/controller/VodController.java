package com.example.vueboot.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.commonutils.R;
import com.example.vueboot.server.VodService;

import com.example.vueboot.util.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@RestController
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    //上传视频到阿里云
    @PostMapping("uploadAlyiVideo")
    public String uploadAlyiVideo(@RequestParam("file") MultipartFile file) throws ClientException {
        System.out.println("文件"+file);
        //返回上传视频id
        String videoId = vodService.uploadVideoAly(file);
        System.out.println("文件是否上传成功"+videoId);
        return videoId;
    }
    //查询视频的url
     @RequestMapping("/select")
    public  String url() throws ClientException {
         try {
             //查询视频的url
             String url=vodService.selecturl("046fc204565d48a6a0734a299940360f");
             System.out.println("地址"+url);
             return  url;
         }catch (Exception e){
             return "视频不存在";
         }

     }

//
//     //删除视频
     @RequestMapping("/delete")
     public  String delete() throws ClientException {
         //删除视频
         try {
             int delete = vodService.delete("f3defea4895c4024b0602a9cdc0d39c7");
             if (delete > 0) {
                 System.out.println("删除成功");
             } else {
                 System.out.println("删除失败");
             }
             return "删除成功";
         }catch (Exception e){
             return "视频已删除";
         }
     }


     @Autowired
     private  OssUtil ossUtil;
     //上传图片到oss
     @RequestMapping("/addimg")
     public R addimg(@RequestPart MultipartFile file){
         System.out.println("file"+file);
         String uuid=UUID.randomUUID().toString();
         System.out.println("uuid"+uuid);
         String url= ossUtil.uploadFile(file,uuid);
         return R.ok();
     }

}
