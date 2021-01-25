package com.example.controller;

import com.example.commonutils.R;
import com.example.po.OpGiftEntity;
import com.example.server.WebPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    WebPay webPay;
    @RequestMapping("/alipay")
    public void pay(HttpServletResponse response,@RequestBody OpGiftEntity o) throws UnsupportedEncodingException {
        System.out.println("支付.....");
        System.err.println(o instanceof OpGiftEntity);
        webPay.send(response,o);
    }
}