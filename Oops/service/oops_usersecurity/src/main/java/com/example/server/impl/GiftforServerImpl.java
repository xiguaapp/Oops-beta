package com.example.server.impl;

import com.example.dao.GiftforDao;
import com.example.po.Op_giftfor;
import com.example.server.GiftforServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GiftforServerImpl implements GiftforServer {

    @Autowired
    private GiftforDao giftforDao;


    @Override
    public List<Op_giftfor> brush(Integer userid) {
        return giftforDao.brush(userid);
    }

    @Override
    public List<Op_giftfor> obtain(Integer userid) {
        return giftforDao.obtain(userid);
    }

    @Override
    public int addinterme(Map<String,Object> map) {
        return giftforDao.addinterme(map);
    }

    @Override
    public int addgif(Map<String, Object> map) {
        return giftforDao.addgif(map);
    }
}
