package com.example.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//会员表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Op_Vip {
    private int vid;       //会员id
    private String vname;  //会员名称
    private String vprice; //会员价格
}
