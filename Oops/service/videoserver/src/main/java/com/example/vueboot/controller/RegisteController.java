package com.example.vueboot.controller;

import com.example.vueboot.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class RegisteController {

    @RequestMapping("/vue")
    public Map vue(){
        System.out.println("前端访问成功....用户名");
        Map<String,Object> map=new HashMap<>();
        map.put("id",1);
        map.put("name","哈哈哈哈哈");
        map.put("authorname","Thomas");
        return map;
    }

    //只要接口中,返回值存在实体类,就会被扫描到swagger中
    @PostMapping("/vue/user")
    public User user(){
        User user=new User("Thomas","123456");
        return user;
    }

    //ApiOperation 给接口加一个中文注释
    //ApiParam 给参数加中文注释
    @ApiOperation("Hello控制方法")
    @GetMapping("/vue/hello")
    public User hello(User user){
        return user;
    }
}
