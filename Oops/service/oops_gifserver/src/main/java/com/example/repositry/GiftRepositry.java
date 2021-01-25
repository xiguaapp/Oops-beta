package com.example.repositry;

import com.example.po.OpGiftEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GiftRepositry {
    //giftlist 查询所有礼物
    List<OpGiftEntity> giftlist();
    //查询背包的礼物
    List<OpGiftEntity> gifbags(int userid);
    // 修改礼物的数量
    int upgifbags(int userId,int gifId);

    //判断礼物是否已经购买购买了就修改数量
    OpGiftEntity isbags(@Param("gifid") int gifid, @Param("userid") int userid);

    // 修改礼物的数量
    int adgifbags(@Param("userId") int userId,@Param("gifId") int gifId);

    //添加礼物到背包
    int addbeibao(@Param("userId") int userId,@Param("gifId") int gifId);
}
