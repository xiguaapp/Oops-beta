package com.example.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//用户表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int    userId;   //用户id
    private String userName; //用户昵称
    private String userPass; //用户密码
    private int    lvl;      //用户等级
    private float  userConst; //用户R币
    private Date   userCreateTime; //创建时间
    private Date   userUpdateTime; //修改时间
    private int    deleted;  // 逻辑删除
    private int    baned;    // 是否禁用
    private int    vid;      //会员id
    private int    integral; //积分
    private String head;     //用户头像
    private String phone;    //用户手机号
    private int oid; //会员消费记录id
    private String expire;  //会员到期日期

    //用户描述
    private String signature;

    //关注列
    private OpAttentionEntity opAttentionEntity;

    //会员表
    //private OpUserconstEntity op_userconst;
}
