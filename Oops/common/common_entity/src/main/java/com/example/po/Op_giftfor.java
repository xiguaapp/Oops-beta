package com.example.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//礼物送出和礼物获取的礼物
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Op_giftfor {
   private  int gid; //自增id
   private String gname;//礼物名称
   private int R; //礼物R币
   private int money; //收益原金额;
   private int userid; //送礼的用户id
   private int water; //平台抽完水后的收益金额
   private int inuserid; //收礼的用户
}