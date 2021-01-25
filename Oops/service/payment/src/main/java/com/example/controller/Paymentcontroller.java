package com.example.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.po.OpUserconstEntity;
import com.example.server.PaymentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//支付模块
@RestController
@RequestMapping("/pay/filtration")
public class Paymentcontroller {

    @Autowired
    private PaymentServer paymentServer;

    //查询充值中心的消费记录 消费名称  消费时间 消费金额
    @PostMapping("/record")
    public R record(HttpServletRequest request){
//        for (OpUserconstEntity sy:paymentServer.record(2)){
//            System.out.println("支付方式"+sy.getType());
//        }
//        获取token
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userid=verify.getClaim("userid").asInt();
//        map.put("record",paymentServer.record(userid));
        System.out.println("查询充值记录....");
        return R.ok().message(paymentServer.record(userid));
    }
    //添加充值中心的消费记录 消费名称  消费时间 消费金额

    //添加购买记录 金额+用户id
    @PostMapping("/addrecord")
    public int addrecord(@RequestParam int userid,@RequestParam int money){
        System.out.println("用户id"+userid+"金额"+money);
        int in=paymentServer.addrecord(userid,"礼物充值",money);

        return in;
    }
}
