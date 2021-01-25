package com.example.server.impl;

import com.example.dao.UserDao;
import com.example.po.OpUserEntity;
import com.example.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserDao userDao;

    @Override
    public int Usersadd(OpUserEntity opUserEntity) {
        return userDao.Usersadd(opUserEntity);
    }

    @Override
    public List<OpUserEntity> list_user() {
        return userDao.list_user();
    }

    @Override
    public OpUserEntity login(String phone, String...pwd) {
        if(pwd.length>0 && pwd!=null){
          return  userDao.login(phone,pwd[0]);
        }
        return userDao.login(phone,null);
    }

    @Override
    public OpUserEntity findpslhpage(Integer userId) {
        System.out.println("参数"+userId);
        return userDao.findpslhpage(userId);
    }

    @Override
    public int change(Map<String, Object> map) {
        return userDao.change(map);
    }

    @Override
    public int amend(Map<String, Object> map) {
        return userDao.amend(map);
    }

    @Override
    public int changepwd(Map<String, Object> map) {
        return userDao.changepwd(map);
    }

    @Override
    public int upuserConst(Integer r, Integer userId) {
        return userDao.upuserConst(r,userId);
    }

    @Override
    public OpUserEntity selectue(int userid) {
        return userDao.selectue(userid);
    }
}
