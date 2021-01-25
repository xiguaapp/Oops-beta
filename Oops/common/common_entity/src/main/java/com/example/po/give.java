package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//点赞
//mongodb文档 点赞
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="give")
public class give {
    //id就是用户id
    //用户id
    @Id
    private  Object userid;
    //自己的id
    private  Object zjid;
    //用户名称
    private  Object userName;
    //用户头像url
    private Object  head;
    //视频id
    private  Object vid;
    //视频地址url
    private  Object vurl;
    //点赞时间
    private String datime;
}
