package com.example.dao;

import com.example.po.Op_Video;
import com.example.po.VideObjet;

import java.util.List;
import java.util.Map;

public interface VideoDao{
    //查询用户的个人视频
    List<Op_Video>  personage(Integer userId);

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

    int invideo(Map<String,Object> map);
}
