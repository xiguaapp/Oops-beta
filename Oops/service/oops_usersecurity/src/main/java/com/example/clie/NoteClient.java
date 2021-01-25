package com.example.clie;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="nacos-supermarket-gateway-abc",contextId ="not-pro")
@RequestMapping("/note/filter")
@Component
public interface NoteClient {

    //短信服务接口
    @PostMapping("/scode")
    public boolean scode(@RequestParam String phone, @RequestParam String code);
}
