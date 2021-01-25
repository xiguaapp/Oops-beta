package com.example.server;

import com.example.dao.PaymentDao;
import com.example.po.OpUserconstEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PaymentServerImpl implements PaymentServer {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public List<OpUserconstEntity> record(Integer userId) {
        return paymentDao.record(userId);
    }

    @Override
    public int addrecord(int userId, String type, int money) {
        return paymentDao.addrecord(userId,type,money);
    }
}
