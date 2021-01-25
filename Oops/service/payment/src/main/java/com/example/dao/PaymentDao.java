package com.example.dao;

import com.example.po.OpUserconstEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentDao {
    List<OpUserconstEntity> record(Integer userId);

    //添加购买记录 用户id 充值类型 充值金额或R币
    int addrecord(@Param("userId") int userId,
                  @Param("type") String type,
                  @Param("money") int money);

}
