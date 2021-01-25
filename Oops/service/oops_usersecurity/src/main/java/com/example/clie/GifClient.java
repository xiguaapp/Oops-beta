package com.example.clie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name="nacos-supermarket-gateway-abc",contextId ="gif-pro")
@RequestMapping("/gift/filtration")
@Component
public interface GifClient {
    @PostMapping("/addbeibao")
      //用户id:userId 礼物id:gifId
    public int addbeibao(@RequestParam Integer userid,@RequestParam Integer gifId);
}
