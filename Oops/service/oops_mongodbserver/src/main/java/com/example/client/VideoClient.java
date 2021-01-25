package com.example.client;

import com.example.po.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name="nacos-supermarket-gateway-abc",contextId ="mongo-pro")
@RequestMapping("/videoserver/filtration")
@Component
public interface VideoClient {
    @RequestMapping("/count")
    public List<VideObjet> getListByCount();
    @RequestMapping("/weight")
    public List<VideObjet> getListByWeight();
}
