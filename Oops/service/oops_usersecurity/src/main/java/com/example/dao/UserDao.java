package com.example.dao;


import com.example.po.OpUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //添加用户
    int Usersadd(OpUserEntity opUserEntity);

    //测试查询
    List<OpUserEntity> list_user();

    //用户登录可选择短息验证或密码验证
    OpUserEntity login(String phone, String pwd);

    //查询个人信息
    OpUserEntity findpslhpage(Integer userId);
    //查询电话号码是否存在 如果存在则是登录,登录不需要弹出设置页面
    //电话号码不存在就是注册 ,注册就需弹出设置密码页面
    int change(Map<String,Object> map);


    //修改个人资料
    int amend(Map<String,Object> map);

    //修改密码
    int changepwd(Map<String,Object> map);

    //用户购买礼物扣除用户对应的R币 前端判断用户的R币是否充足+后端也加判断
    //扣除对应的R币
    //购买成功通过mq发送购买成功 把礼物添加到背包里
    //在把购买的礼物添加到购买记录表里
    //使用全局事物
    int purchase();

    //查询余额
    OpUserEntity selectue(int userid);

    //扣除金额
    int upuserConst(@Param("r") Integer r,@Param("userId") Integer userId);


}
