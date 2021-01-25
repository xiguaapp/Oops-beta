package com.example.repositry;

import com.example.po.OpKejinoderEntity;

import java.util.List;

//用户氪金 订单接口
public interface OpKejinoderEntityRepositry {
    List<OpKejinoderEntity> getList(int userId);
}