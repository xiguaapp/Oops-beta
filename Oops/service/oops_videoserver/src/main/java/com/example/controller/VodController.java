package com.example.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
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




}
