package com.example.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.config.MyRabbitMQConfig;
import com.example.po.Op_giftfor;
import com.example.server.GiftforServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/filtration")
@Slf4j
public class GiftforFiltrationController {


    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private GiftforServer giftforServer;

    //查询刷出去的礼物 用户id是自己
    //SELECT * FROM op_giftfor WHERE userid=2
    @RequestMapping("/brush")
    private R brush(HttpServletRequest request){
        //获取token的值 HttpServletRequest request
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        List<Op_giftfor> bu=giftforServer.brush(userids);
        return R.ok().message(bu);

    }
    //查询获取到的礼物 用户id除了自己
    //SELECT * FROM op_giftfor WHERE userid!=2
    @RequestMapping("/obtain")
    private R obtain(HttpServletRequest request){
        //获取token的值 HttpServletRequest request
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("id"+userids);
        List<Op_giftfor> ob=giftforServer.obtain(userids);
        return R.ok().message(ob);
    }
//     /*测试消息发送*/
//    @RequestMapping("/mq")
//    private R mq(){
//        Map<String,Object> map= new HashMap<>();
//        map.put("lisi","lisi");
//        rabbitTemplate.convertAndSend(QueueRabbit.QUEUE_NAME,"hhhhH");
//        return R.ok();
//    }

    //用户送礼物给发布者平台赚取收益
    @RabbitListener(queues = MyRabbitMQConfig.gifSTORY_QUEUE)
    public void commentdecrByStock(Map<String,Object> map) {
        System.out.println("前端获取礼物的昵称,R币,礼物金额," +
                "送礼物id(自己),收礼物id(你送给的用户id)，平台收取后的到账金额");
        System.out.println("mapsuoy"+map);
        Map<String,Object> map1=new HashMap<>();
//        #{gname},
//	#{R},
//	#{money},
//	#{userid},
//	#{water},
//	#{inuserid}
        map1.put("gname",map.get("gname"));
        map1.put("R",map.get("R"));
        map1.put("money",map.get("money"));
        map1.put("userid",map.get("upuserid"));
        map1.put("water",map.get("money"));
        map1.put("inuserid",map.get("map[userId]"));

        System.out.println("记录添加"+map1);
        //礼物记录添加
        int nus=giftforServer.addgif(map1);
        if (nus>0){
            System.out.println("添加成功");
        }

        //添加礼物记录中间表
        int nums=giftforServer.addinterme(map1);
        if(nums>0){
            System.out.println("添加成功2");
        }
//        int nums=giftforServer.addinterme()
//        System.out.println("mapsuoy"+map);
        //礼物中间表添加

    }
}