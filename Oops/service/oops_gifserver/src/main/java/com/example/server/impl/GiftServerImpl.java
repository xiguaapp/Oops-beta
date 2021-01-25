package com.example.server.impl;

import com.example.po.OpGiftEntity;
import com.example.repositry.GiftRepositry;
import com.example.server.GiftServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftServerImpl  implements GiftServer {
    @Autowired
    GiftRepositry giftRepositry;
    @Override
    public List<OpGiftEntity> giftlist() {
        return giftRepositry.giftlist();
    }

    @Override
    public List<OpGiftEntity> gifbags(int userid) {
        return giftRepositry.gifbags(userid);
    }

    @Override
    public int upgifbags(int userId, int gifId) {
        return giftRepositry.upgifbags(userId,gifId);
    }

    @Override
    public int addbeibao(int userId, int gifId) {
        return giftRepositry.addbeibao(userId,gifId);
    }

    @Override
    public OpGiftEntity isbags(int gifid,int userid) {
        return giftRepositry.isbags(gifid,userid);
    }

    @Override
    public int adgifbags(int userId, int gifId) {
        return giftRepositry.adgifbags(userId,gifId);
    }
}
