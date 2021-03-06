package com.example.server;

import com.example.po.Op_giftfor;

import java.util.List;
import java.util.Map;

public interface GiftforServer {

    //查询送出去的礼物
    List<Op_giftfor> brush(Integer userid);

    //查询收到的礼物
    List<Op_giftfor>  obtain(Integer userid);

    //添加记录中间表
    int addinterme(Map<String,Object> map);

    //添加礼物记录
    int addgif(Map<String,Object> map);

}
