package com.example.clie;

import com.example.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@FeignClient(name="nacos-supermarket-gateway-abc",contextId ="psdy-pro")
@RequestMapping("/pay")
@Component
public interface PayClient {
    @RequestMapping("/alipay")
    public void pay(@RequestBody Object o) throws UnsupportedEncodingException;

    //添加礼物服务

    //添加购买记录表
    //添加购买记录
    //添加购买记录 金额+用户id
    @PostMapping("filtration/addrecord")
    public int addrecord(@RequestParam int userid, @RequestParam int money);

}
