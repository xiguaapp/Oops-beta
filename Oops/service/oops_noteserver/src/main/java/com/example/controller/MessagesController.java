package com.example.controller;


import com.example.server.ElseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/note/filter")
@CrossOrigin
public class MessagesController{

    @Autowired
    private ElseServer elseServer;

    //测试
    @PostMapping("/scode")
        public boolean scode(@RequestParam String phone,@RequestParam String code){
        System.out.println("手机号"+phone+"验证码"+code);
        elseServer.hklq(phone,code);
        return true;
    }

}
