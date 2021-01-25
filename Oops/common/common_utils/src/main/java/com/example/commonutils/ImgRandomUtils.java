package com.example.commonutils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ImgRandomUtils {

    public static String random(){
        //随机图片图片
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"\n" +
                "https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%871.jpg");
        map.put(2,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%8710.jpg");
        map.put(3,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%8711.jpg");
        map.put(4,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%8712.jpg");
        map.put(5,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%872.jpg");
        map.put(6,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%873.jpg");
        map.put(7,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%874.jpg");
        map.put(8,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%874.jpg");
        map.put(9,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%874.jpg");
        map.put(10,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%874.jpg");
        map.put(11,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%874.jpg");
        map.put(12,"https://guil-file-200211.oss-cn-beijing.aliyuncs.com/Oops/Oops%E9%BB%98%E8%AE%A4%E5%9B%BE%E7%89%874.jpg");
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Random random = new Random();
        Integer randomKey = keys[random.nextInt(keys.length)];
        String randomValue = map.get(randomKey);

        return randomValue;
    }
}
