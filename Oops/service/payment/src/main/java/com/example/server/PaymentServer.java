package com.example.server;

import com.example.po.OpUserconstEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentServer {
    List<OpUserconstEntity> record(Integer userId);
    //添加购买记录 用户id 充值类型 充值金额或R币
    int addrecord(int userId,
                  String type,
                  int money);
}