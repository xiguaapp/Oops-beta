package com.example.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//mongodb文档 弹幕表
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="szgs")
public class Book implements Serializable {
//    private String id;     //弹幕id
//    private int userid;//用户id
//    private int video_id;  //视频id
//    private String text;   //弹幕内容
//    private String head;   //用户头像
//    private String createTime;//评论时间
    private String avatar;
    private String msg;
    private int time;
    private String barrageStyle;
    private String name;
    private int vid;
}
