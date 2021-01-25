package com.example.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.config.MyRabbitMQConfig;
import com.example.po.OpAttentionEntity;
import com.example.server.AttentionServer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//关注者,和被工作者
@RestController
@RequestMapping("/user/filtration")
public class AttentionController {


    @Autowired
    private AttentionServer attentionServer;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //查询关注的用户
    @RequestMapping("/attention")
    public R attention(){
        List<OpAttentionEntity> ation=attentionServer.attention(2);
       return R.ok().message(ation);
    }

    //查询粉丝
    @RequestMapping("/fans")
    public R fans(){
        List<OpAttentionEntity> fanstion=attentionServer.fans(2);
        return R.ok().message(fanstion);
    }

    //添加关注
    @PostMapping("/inverdict")
    public R inverdict(Integer userid,@RequestParam Map<String,Object> userlist,HttpServletRequest request) {
        System.out.println("用户id" + userid);
        System.out.println("用户信息..."+userlist);
        rabbitTemplate.convertAndSend(
                MyRabbitMQConfig.fansSTORY_EXCHANGE, MyRabbitMQConfig.fansSTORY_ROUTING_KEY,userlist);
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        Integer userids = verify.getClaim("userid").asInt();
        System.out.println("token携带的用户id" + userids);
        /*userids:我自己
         * 关注用户id:userid
         * */
        int num = attentionServer.inverdict(userids, userid);
        System.out.println(num);
        if (num > 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //取消关注

    @PostMapping("/deverdict")
    public R deverdict(Integer userid, HttpServletRequest request) {
        System.out.println("用户id" + userid);
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        Integer userids = verify.getClaim("userid").asInt();
        System.out.println("token携带的用户id" + userids);
        /*userids:我自己
         * 关注用户id:userid
         * */
        int num = attentionServer.deverdict(userids, userid);
        System.out.println(num);
        if (num > 0) {
            return R.ok();
        } else {
            return R.error();
        }
    }
}