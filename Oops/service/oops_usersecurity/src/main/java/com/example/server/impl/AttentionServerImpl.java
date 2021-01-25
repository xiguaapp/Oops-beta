package com.example.server.impl;

import com.example.dao.AttentionDao;
import com.example.po.OpAttentionEntity;
import com.example.server.AttentionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttentionServerImpl implements AttentionServer {


    @Autowired
    private AttentionDao attentionDao;

    @Override
    public List<OpAttentionEntity> attention(int attentionUid) {
        return attentionDao.attention(attentionUid);
    }

    @Override
    public List<OpAttentionEntity> fans(int beattentionuid) {
        return attentionDao.fans(beattentionuid);
    }

    @Override
    public OpAttentionEntity verdict(int auserid, int buserid) {
        return attentionDao.verdict(auserid,buserid);
    }

    @Override
    public int inverdict(int attentionUid, int beAttentionUid) {
        return attentionDao.inverdict(attentionUid,beAttentionUid);
    }

    @Override
    public int deverdict(int attentionUid, int beAttentionUid) {
        return attentionDao.deverdict(attentionUid,beAttentionUid);
    }
}
