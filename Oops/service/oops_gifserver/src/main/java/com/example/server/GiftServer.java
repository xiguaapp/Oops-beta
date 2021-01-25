package com.example.server;

import com.example.po.OpGiftEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GiftServer {
    List<OpGiftEntity> giftlist();

    List<OpGiftEntity> gifbags(int userid);

    // 修改礼物的数量
    int upgifbags(int userId,int gifId);

    //添加礼物到背包
    int addbeibao(int userId,int gifId);


    //判断礼物是否已经购买购买了就修改数量
    OpGiftEntity isbags(int gifid,int userid);

    // 修改礼物的数量
    int adgifbags(@Param("userId") int userId, @Param("gifId") int gifId);

}
