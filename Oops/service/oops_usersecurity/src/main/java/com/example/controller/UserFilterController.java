package com.example.controller;

import cn.hutool.core.util.IdUtil;
import com.example.clie.NoteClient;
import com.example.commonutils.ImgRandomUtils;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.po.OpUserEntity;
import com.example.server.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user/filter")
@Slf4j
public class UserFilterController {

    //阿里巴巴短信服务接口
    @Autowired
    private NoteClient noteClient;

    //reids缓存
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserServer userServer;

    //发送短信
    @PostMapping("/transmit")
    public  void transmit(@RequestParam String phone){
        System.out.println("手机号:"+phone);
        //生成四位随机数
        String code = String.valueOf((int)((Math.random()*9+1)*1000));
        System.out.println("验证码"+code);
        //调用阿里云的短信服务
        boolean flage=noteClient.scode(phone,code);
//        boolean flage=true;
        if(flage==true){
            System.out.println("发送成功");
            //发送成功验证码存到redis中
            redisTemplate.opsForValue().set(phone,code,90, TimeUnit.SECONDS);
        }else {
            System.out.println("发送失败");
        }
    }
    //验证验证码是否正确并且判断手机号是否存在数据库
    //验证码正确,则直接登录
    //验证码正确,手机号不存在数据库,则判定是新用户,跳到设置密码页面
    @PostMapping("/login")
    public R verify(@RequestParam String phone,@RequestParam String code){
        //验证短信是否正确
        System.out.println("手机号码"+phone+"验证码"+code);
        String vcode = redisTemplate.opsForValue().get(phone);
        log.info("取出缓存中手机号的验证码是:"+vcode);
        if(vcode==null){
            return R.error().data("code",400);
        }else {
//      System.out.println("是否正确"+vcode.equals(code));
            if (vcode.equals(code)) {
                //匹配成功判断是否是新用户,新用户跳转到设置密码页面,否则直接去首页
                OpUserEntity num = userServer.login(phone);
                if (num == null) {
                    //新用户去设置密码页面
                    return R.ok().message("/setting").data("code",201);
                } else {
                    //老用户验证码通过直接去个人中心,生成密钥
                    Map<String, Integer> MapToken = new HashMap<>();
                    MapToken.put("userid", num.getUserId());
                    //生成JWT令牌
                    String token = JwtUtils.getToken(MapToken);
                    Map<String, Object> map = new HashMap<>();
                    map.put("token", token);
                    map.put("code", 200);
                    System.out.println("令牌" + token);
                    return R.ok().message("/me").data(map);
                }
            } else {
                return R.error().data("code",401);
//                return R.error().message("验证码不匹配");
            }
        }
    }


    //用户登录 根据电话+密码
    @PostMapping("/loginpass")
    public R loginpass(String phone,String password){
        System.out.println("电话"+phone+"密码"+password);
        OpUserEntity num=userServer.login(phone,password);
        if (num!=null){
            System.out.println("昵称"+num.getUserName());
            Map<String, Integer> MapToken = new HashMap<>();
            MapToken.put("userid", num.getUserId());
            //保存token
            String token = JwtUtils.getToken(MapToken);
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("code", 200);
            System.out.println("令牌" + token);
            return R.ok().data(map);
        }else{
            return R.error();
        }
    }


    //注册用户,注册成功则不需要再一次登录
    @PostMapping("/register")
    public R register(@RequestParam String phone,@RequestParam String password){
        System.out.println("执行用户注册"+"电话"+phone+"密码"+password);
        OpUserEntity user=new OpUserEntity();
        //默认昵称uuid
        String simpleUUID = IdUtil.simpleUUID().substring(0,4);
        System.out.println("昵称"+simpleUUID);
        String img= ImgRandomUtils.random();
        System.out.println("图片"+img);
        user.setPhone(phone);
        user.setUserPass(password);
        user.setHead(img);
        user.setUserName("Oops"+simpleUUID);
        int num=userServer.Usersadd(user);
        if (num>0){
            System.out.println("插入成功返回主键id"+user.getUserId());
            Map<String, Integer> MapToken = new HashMap<>();
            MapToken.put("userid",user.getUserId());
            //生成JWT令牌
            String token = JwtUtils.getToken(MapToken);
            System.out.println("生成token"+token);
            return R.ok().message("/me").data("token",token);
        }else {
            return R.error().message("/sign");
        }
    }
}