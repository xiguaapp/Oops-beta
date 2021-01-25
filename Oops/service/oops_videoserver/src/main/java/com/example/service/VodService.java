package com.example.service;

import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    //    String uploadVod(MultipartFile file);
//
//    void deleteALYVod(String id); //删除单个视频
//
//    void deleteALLVod(List<String> ids); //删除多个视频
    //上传视频到阿里云
    String uploadVideoAly(MultipartFile file);

    //根据id查询视频url
    String selecturl(String id) throws ClientException;

    //删除视频
    int delete(String id) throws ClientException;
}
