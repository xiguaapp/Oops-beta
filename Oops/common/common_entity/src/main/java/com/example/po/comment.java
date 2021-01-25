package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

//评论
//mongodb文档 评论
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="comment")
public class comment {
    //id自动设置 一个用户可以发送多条评论
    private  Object userid;
    //用户名称
    private Object userName;
    //用户头像url
    private  Object head;
    //视频id
    private  Object vid;
    //视频地址url
    private  Object vurl;
    //评论内容
    private  Object content;
    //评论时间
    private  String datime;
}