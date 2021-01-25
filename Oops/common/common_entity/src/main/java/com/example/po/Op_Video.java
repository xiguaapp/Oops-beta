package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


//视频表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Op_Video {

    //视频id
    private int videoId;
    //用户id
    private  int userId;
    //时评路径
    private String videoUrl;
    //视频点赞数
    private int videoCount;
    //视频权重
    private int weight;
    //视频状态
    private int videoStatus;
    //视频上传时间
    private Date videoTime;
    //视频描述
    private String videoDescript;
    //阿里云视频点播的视频id
    private String oosId;

}
