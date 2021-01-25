package com.example.service;

import com.example.po.Op_Video;
import com.example.po.VideObjet;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface VideoServer {
    //查询用户的个人视频
    List<Op_Video> personage(Integer userId);

    //查询视频详情
    Op_Video peVideo(Integer videoId);

    //查询权重最高的用户 排序
    List<VideObjet> getListByWeight();
    //查询点击最高的用户
    List<VideObjet> getListByCount();

    //查询关注人的视频
    List<VideObjet> attentionlist(Integer attentionUid);

    //修改视频的喜欢数量
    int updatecount(Map<String,Object> map);


    //上传视频到阿里云
    String uploadVideoAly(MultipartFile file);

    //根据id查询视频url
    String selecturl(String id) ;

    //删除视频
    int delete(String id) ;

    //添加视频
    int invideo(Map<String,Object> map);
}
