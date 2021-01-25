package com.example.service.impl;

import com.example.po.OpKejinoderEntity;
import com.example.repositry.OpKejinoderEntityRepositry;
import com.example.service.OpKejinoderEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpKejinoderEntityServiceImpl implements OpKejinoderEntityService {
    @Autowired
    OpKejinoderEntityRepositry opKejinoderEntityRepositry;
    @Override
    public List<OpKejinoderEntity> getList(int userId) {
        return opKejinoderEntityRepositry.getList(userId);
    }
}
