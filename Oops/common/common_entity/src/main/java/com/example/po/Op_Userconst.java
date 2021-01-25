package com.example.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//会员信息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Op_Userconst {
    private int cid;   //主键id
    private  int userId; //用户id
    private  String type; //充值方式
    private  Date payTime;  //充值时间
    private  int  v_id;  //消费套餐id
    private  Date expire; //会员到期时间
    private  String money; //会员充值金额
}
