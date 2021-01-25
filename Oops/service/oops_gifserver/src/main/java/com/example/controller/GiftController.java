package com.example.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.config.MyRabbitMQConfig;
import com.example.po.OpGiftEntity;
import com.example.server.GiftServer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gift/filtration")
public class GiftController {

    //rabbitTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    GiftServer giftServer;
    //查询所有礼物
    @RequestMapping("/giftlist")
    public R getAllGift(){
        List<OpGiftEntity> giftlist = giftServer.giftlist();
        return R.ok().data("giftlist",giftlist);
    }

    //查询用户背包的礼物
    @RequestMapping("/gifbags")
    public R gifbags(HttpServletRequest request){
        System.out.println("查询背包");
        //获取token
       //获取token的值 HttpServletRequest request
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("tokenid"+userids);
        List<OpGiftEntity> gifbags = giftServer.gifbags(userids);
        System.out.println("背包的礼物"+gifbags);
        return R.ok().data("gifbags",gifbags);
    }



    //判断是否是用户
    //平台收取百分之30
    @RequestMapping("/upgifbags")
    public R upgifbags(@RequestParam Map<String,Object> map, HttpServletRequest request){
        System.out.println("修改送出去的礼物"+map);
        //获取token的值 HttpServletRequest request
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("tokenid"+userids);
        //判断自己不能给自己送礼物
        System.out.println("哈哈哈");
        String id=map.get("map[userId]").toString();
        System.out.println("id"+id+"是否为true"+id.equals(userids.toString()));
        if (id.equals(userids.toString())){
            System.out.println("自己不能给自己送礼物");
            return R.ok().message("自己不能给自己送礼物");
        }else{
            Integer gid=Integer.parseInt((String) map.get("giftid"));
            System.out.println("礼物id"+gid);
            int ido=giftServer.upgifbags(userids,gid);
             if(ido>0){
                 System.out.println("礼物送出成功");
                 //送礼物的id
                 map.put("upuserid",userids);
                 //平台抽取百分之20
                 map.put("water","1232");
                 rabbitTemplate.convertAndSend(
                         MyRabbitMQConfig.gifSTORY_EXCHANGE, MyRabbitMQConfig.gifSTORY_ROUTING_KEY,map);
                 return R.ok().message(true);
             }else {
                 System.out.println("礼物送出失败");
                 return R.ok().message(false);
             }

        }
        //List<OpGiftEntity> gifbags = giftServer.gifbags(2);
    }


}