package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//粉丝关注
//关注
//mongodb文档 关注
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="fans")
public class fans {
    //id就是用户id
    //用户id
    @Id
    private Object userid;
    //自己的id
    private Object zjid;
    //用户头像地址
    private Object  head;
    //用户昵称
    private  Object userName;
    //用户关注的时间
    private String datime;

}
