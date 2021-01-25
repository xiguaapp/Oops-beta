package com.example.clie;


import com.example.po.Op_Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="nacos-supermarket-gateway-abc",contextId ="video-pro")
@RequestMapping("/videoserver/filtration")
@Component
public interface VideoClient {

    @PostMapping("/personalV")
    public List<Op_Video> filtration(@RequestParam Integer userId,@RequestHeader String token);

}
