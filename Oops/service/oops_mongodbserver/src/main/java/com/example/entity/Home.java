package com.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("users")
public class Home {
//     *    id;     //弹幕id
//     *    userid;//用户id
//     *    text;   //弹幕内容
//     *    head;   //用户头像
//     *    createTime;//评论时间

/*  梁鑫:
    private int userId;//上传视频人的id 用于接收打赏用
    @Id
    private int videoId;//视频的id 用于点开查询大图
    private String videoDescript;//视频的描述
    private  String videoUrl;//视频的url*/

    @Id
    private  int videoId;
    private  int userId;
    private  String videoUrl;
    private  int videoCount;
    private  int weight;
    private  int videoStatus;
    private Date videoTime;
    private  String videoDescript;
    private  String oosId;
    private  String userName;
    private  String head;
}
