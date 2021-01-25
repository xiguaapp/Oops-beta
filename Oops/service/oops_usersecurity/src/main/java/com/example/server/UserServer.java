package com.example.server;

import com.example.po.OpUserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserServer {

    //添加用户
    int Usersadd(OpUserEntity user);

    //测试查询
    List<OpUserEntity> list_user();

    //用户登录可选择短息验证或密码验证
    OpUserEntity login(String phone, String... pwd);

    //查询个人信息
    OpUserEntity findpslhpage(Integer userId);

    //修改密码
    int change(Map<String,Object> map);

    //修改个人资料
    int amend(Map<String,Object> map);

    //修改密码
    int changepwd(Map<String,Object> map);

    //扣除金额
    int upuserConst(Integer r,Integer userId);

    //查询余额
    OpUserEntity selectue(int userid);

}
