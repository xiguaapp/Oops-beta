package com.example.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.server.ElseServer;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ElseServerImpl implements ElseServer {
    @Override
    public boolean hklq(String phone, String code) {
        //链接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-", "", "");
        IAcsClient client = new DefaultAcsClient(profile);

        System.out.println("手机号"+phone+"短信"+code);

        //构建请求!
        CommonRequest request = new CommonRequest();

        request.setSysMethod(MethodType.POST);
        request.setSysDomain("");//不要动
        request.setSysVersion(""); //不要动
        request.setSysAction("");

        request.putQueryParameter("PhoneNumbers",phone);
        //签名
        request.putQueryParameter("SignName", "");
        //模板
        request.putQueryParameter("TemplateCode", "");
        //构建一个短信的验证码
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",code);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
