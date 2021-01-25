package com.example.controller;

import com.example.clie.PayClient;
import com.example.po.OpGiftEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/user/filtration")
public class ceshiController {

    @Autowired
    PayClient payClient;

    @RequestMapping("/pay")
    public void  pay() throws UnsupportedEncodingException {
        System.out.println("进来了....");
        OpGiftEntity opGiftEntity=new OpGiftEntity();
        opGiftEntity.setGifprice(11);
        opGiftEntity.setGifname("肖凯的小电影");
        opGiftEntity.setGifimageurl("dsadasdasda");
        opGiftEntity.setGiftid(122);
        payClient.pay(opGiftEntity);
    }
}