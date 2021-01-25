package com.example.controller;


import com.example.clie.NoteClient;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.po.OpUserEntity;
import com.example.server.UserServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private UserServer userServer;

    @Autowired
    private NoteClient noteClient;

    //reids缓存
    @Autowired
    private StringRedisTemplate redisTemplate;

    //验证手机号码是否存在
    @RequestMapping("/verify")
    public R verify(@RequestParam String phone){
        System.out.println("手机号码");
        return R.ok().message("已存在");
    }
    //测试
    //统一返回结果
    //String token = webRequest.getHeader("token");

    //登录验证测试接口网关不过滤
    @PostMapping("/login")
    public R login(@RequestParam String phone){
        //获取tokend的值
        System.out.println("前端登录成功"+phone);
       //System.out.println("电话"+phone+"密码"+pwd);
        return  R.ok();
    }

    //网关过滤测试接口
    @PostMapping("/lo")
    public R lo(@RequestParam String phone){
        //获取tokend的值
        System.out.println("前端登录成功"+phone);
        //System.out.println("电话"+phone+"密码"+pwd);
        return  R.ok();
    }


    //登录验证
//    @PostMapping("/login")
//    public User login(@RequestParam  String phone,@RequestParam String...pwd){
//        //获取tokend的值
//        System.out.println("电话"+phone+"密码"+pwd);
//        return  userServer.login(phone,pwd);
//    }
    /*验证用户的手机号是否已注册,如果已经注册则不用设置密码
    否则就断定用户是新用户跳到设置密码页面就行注册*/
    @PostMapping("/exist")
    public R exist(@RequestParam String phone){
        OpUserEntity num=userServer.login(phone);
     return  R.ok();
    }

    //发送短信验证码
    @PostMapping("/hklq/{phone}")
    public void hklq(@PathVariable("phone") String phone){
        System.out.println("手机号:"+phone);
        //生成四位随机数
        String code = String.valueOf((int)((Math.random()*9+1)*1000));
        boolean flag=noteClient.scode(phone,code);
//        boolean flag=true;
        System.out.println("是否发送短信"+flag);
        if(flag=true){
            //发送成功 把值存在redis中并设置验证码的过期时间
            //缓存中最常用的方法 //设置缓存过期时间为90  时间号码 验证码   单位：秒
            redisTemplate.opsForValue().set(phone,code,90,TimeUnit.SECONDS);
            System.out.println("存入缓存成功");
        }else{
            System.out.println("发送失败");
        }
    }
    //获取短信验证码
    //添加用户
    @PostMapping("/adduser")
    public int adduser(@RequestBody OpUserEntity opUserEntity){
        return userServer.Usersadd(opUserEntity);
    }

    //请求头token测试
    @RequestMapping("/tho")
    public String tho(@RequestParam String name,HttpServletRequest request){
        System.out.println("name:"+name);
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        //System.out.println("token携带的用户信息"+verify.getClaim("username").asString());
        return name;
    }


}
