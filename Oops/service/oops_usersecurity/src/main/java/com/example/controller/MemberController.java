package com.example.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.commonutils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//会员查询
@RestController
@RequestMapping("/user/filtration")
public class MemberController {

    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/member")
    public R member(HttpServletRequest request){
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userid=verify.getClaim("userid").asInt();
        Map<String,Object> map=new HashMap<>();
        map.put("member",redisUtil.getObj(""+userid));
        System.out.println("map:"+map);
        return R.ok().data(map);
    }
}