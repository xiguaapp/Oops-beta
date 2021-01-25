package com.example.controller;

import com.example.po.OpGiftEntity;
import com.example.server.GiftServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/gift/filtration")
public class AddbeibaoController {



    @Autowired
    private GiftServer giftServer;

    //添加礼物到背包里传map值;
    @PostMapping("/addbeibao")
    public int addbeibao(@RequestParam Integer userid, @RequestParam Integer gifId){
        //1.添加成功
        System.out.println("礼物服务userid:"+userid+"gifId"+gifId);
        //判断礼物是否已经购买已经购买就修改礼物数量
        OpGiftEntity entity=giftServer.isbags(gifId,userid);
        if (entity!=null){
            //礼物存在添加修改数据库礼物的数量
            System.out.println("礼物存在修改数量");
            int num=giftServer.adgifbags(userid,gifId);
            return  num;
        }else {
            //礼物不存在添加数据库记录
            System.out.println("礼物不存在添加数据库记录");
            //2.添加礼物
            int num=giftServer.addbeibao(userid,gifId);
            return  num;
        }
    }
}