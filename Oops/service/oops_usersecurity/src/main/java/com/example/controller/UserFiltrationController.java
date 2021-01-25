package com.example.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.clie.GifClient;
import com.example.clie.PayClient;
import com.example.clie.VideoClient;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.commonutils.RedisUtil;
import com.example.po.OpAttentionEntity;
import com.example.po.OpUserEntity;
import com.example.po.Op_Video;
import com.example.server.AttentionServer;
import com.example.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/filtration")
@Slf4j
public class UserFiltrationController {
    @Autowired
    private UserServer userServer;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private AttentionServer attentionServer;

    //调用视频服务
    @Autowired
    private VideoClient videoClient;


    //调用礼物服务
    @Autowired
    private GifClient gifClient;

    //订单模块
    @Autowired
    private PayClient payClient;

    //查询个人信息
    @PostMapping("/pslhpage")
    public R pslhpage(HttpServletRequest request){
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userid=verify.getClaim("userid").asInt();
        System.out.println("token携带的用户id"+userid);
        Map<String,Object> map=new HashMap<>();
        if(redisUtil.getObj(""+userid)==null){
            OpUserEntity user=userServer.findpslhpage(userid);
            if (user==null){
                return R.error();
            }
                System.out.println("查询个人中心...");
                List<Op_Video> opVideoList=videoClient.filtration(userid,token);
                map.put("user1",opVideoList);
                map.put("use2",user);
                redisUtil.setObj("user",user);
                redisUtil.setObj(""+userid,map);
         }
        map.put("user",redisUtil.getObj(""+userid));
        System.out.println("map值"+map);
        return R.ok().data(map);
    }

    //查询某个用户的信息
    @PostMapping("/somezda")
    public R some(Integer userid,HttpServletRequest request){
        System.out.println("用户id"+userid);
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("token携带的用户id"+userids);
        Map<String,Object> map=new HashMap<>();
        if(redisUtil.getObj(""+userid)==null){
            OpUserEntity user=userServer.findpslhpage(userid);
            if (user==null){
                return R.error();
            }
            System.out.println("查询个人中心...");
            List<Op_Video> opVideoList=videoClient.filtration(userid,token);
            map.put("user1",opVideoList);
            map.put("use2",user);
            redisUtil.setObj("user",user);
            redisUtil.setObj(""+userid,map);
        }
        map.put("user",redisUtil.getObj(""+userid));
        OpAttentionEntity attentionEntity=attentionServer.verdict(userids,userid);
        System.out.println("attentionEntity值"+attentionEntity);
        System.out.println("map值"+map);
        return R.ok().data(map).message(attentionEntity);
    }


    //修改个人资料
    @PostMapping("/amend")
    public R amend(@RequestParam Map<String,Object> map,HttpServletRequest request){
    //System.out.println("map的id"+map.get("userId"));
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("token携带的用户id"+userids);
        System.out.println("修改的值Map"+map);
        map.put("uid",userids);
        int num=userServer.amend(map);
        if(num>0){
            redisUtil.del(""+userids);
            return  R.ok();
        }else {
            return  R.error();
        }
    }
    //修改密码
    @PostMapping("/changepwd")
    public R changepwd(@RequestParam Map<String,Object> map,HttpServletRequest request){
        //System.out.println("map的id"+map.get("userId"));
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("token携带的用户id"+userids);
        map.put("uid",userids);
        System.out.println("map密码"+map);
        redisUtil.del(""+userids);
        int num=userServer.changepwd(map);

        if(num>0){
            return  R.ok();
        }else {
            return  R.error();
        }
    }
    //购买的礼物
    @PostMapping("/addpayment")
    public  R addpayment(@RequestParam Integer r,@RequestParam Integer gid,
                         @RequestParam String gifname,HttpServletRequest request){
        //扣除用户数据的R币
        System.out.println("R币"+r);
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("token携带的用户id"+userids);
        //判断R币是否满足购买条件
        OpUserEntity userEntity=userServer.findpslhpage(userids);
        System.out.println("余额"+userEntity.getUserConst());
        if(userEntity.getUserConst()<r){
            return  R.error().message("余额不足");
        }else {
            int uim = userServer.upuserConst(r, userids);
            System.out.println("礼物id" + gid);
            System.out.println("礼物昵称" + gifname);
            if (uim > 0) {
                System.out.println("修改R币成功...");
                //支付完钱后把礼物添加到背包里
                int num = gifClient.addbeibao(userids, gid);
                System.out.println("礼物服务" + num);
                if (num > 0) {
                    System.out.println("订单记录模块");
                    int n = payClient.addrecord(userids, r);
                    if (n > 0) {
                        return R.ok().message(true);
                    } else {
                        return R.error().message(false);
                    }
                } else {
                    return R.error().message(false);
                }
            } else {
                return R.error().message(true);
            }
        }
    }


}