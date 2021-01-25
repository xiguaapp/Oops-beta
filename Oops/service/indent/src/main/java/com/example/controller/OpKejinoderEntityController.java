package com.example.controller;

import com.example.commonutils.R;
import com.example.config.MyRabbitMQConfig;
import com.example.service.OpKejinoderEntityService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/kejin")
public class OpKejinoderEntityController {
    @Autowired
    OpKejinoderEntityService opKejinoderEntityService;

    @RequestMapping("/userKejin/getOne")
    public R getOne(int uid){
        return R.ok().data("kejinList",opKejinoderEntityService.getList(uid));
    }


}
