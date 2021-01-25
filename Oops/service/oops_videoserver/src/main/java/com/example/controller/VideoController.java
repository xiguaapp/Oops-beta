package com.example.controller;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.commonutils.RedisUtil;
import com.example.config.MyRabbitMQConfig;
import com.example.po.Book;
import com.example.po.Op_Video;
import com.example.po.VideObjet;
import com.example.service.MongoDbService;
import com.example.service.VideoServer;
import com.example.service.*;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/videoserver/filtration")
public class VideoController {

    @Autowired
    private VideoServer videoServer;

    @Autowired
    private VodService vodService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private MongoDbService mongoDbService;

    //reids缓存
    @Autowired
    private StringRedisTemplate redisTemplate;

    //rabbitTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping("/personalV")
    public List<Op_Video> filtration(@RequestParam Integer userId,HttpServletRequest request){
        return videoServer.personage(userId);
    }
    //查询视频详情
    @PostMapping("/peVideo")
    public R peVideo(@RequestParam Integer vid, HttpServletRequest request) {
        System.out.println("视频详情"+vid);
        mongoDbService.saveObj();
        //redisUtil.del(""+vid);
        Map<String,Object> map=new HashMap<>();
        List<Book> bookList=mongoDbService.getBookByName(vid);
        if(redisUtil.getObj("V"+vid)==null){
            System.out.println("查询详情视频...");
           Op_Video video=videoServer.peVideo(vid);
            if (video==null){
                return R.error();
            }
            System.out.println("查询详情视频...");
            map.put("video",video);
            redisUtil.setObj("V"+vid,map);
        }
        //map.put(""+vid,redisUtil.getObj(""+vid));
        //获取mongodb的弹幕
        //根据redis的hash 获取视频id对应的点赞数量
        String count=(String) redisTemplate.opsForHash().get("H_v",vid);
        //String sy=(String) redisUtil.getObj("H_v");
        System.out.println("视频喜欢数量"+count);
        map.put("video",redisUtil.getObj("V"+vid));
        map.put("user", redisUtil.getObj("user"));
        map.put("count",count);
        map.put("barrage",bookList);
        //map.put("user",redisUtil.getObj("userName"));
//        String list= (String) redisTemplate.opsForValue().get("userpersonage");
//        System.out.println("list"+list);
//        System.out.println(redisUtil.getObj("" + vid));
        System.out.println(map);
        return R.ok().data(map).message(bookList);
    }

    //以下接口不对外开放 只对对应服务开放
    //查询权重最高的用户 排序
    @RequestMapping("/weight")
    public List<VideObjet> getListByWeight(){
        return  videoServer.getListByWeight();
    }
    //查询点击最高的用户
    @RequestMapping("/count")
    public List<VideObjet> getListByCount(){
        return videoServer.getListByCount();
    }


    //查询关注人的视频
    @RequestMapping("/attentionlist")
    public R attentionlist(HttpServletRequest request){
        String token = request.getHeader("token");
        DecodedJWT verify = JwtUtils.verify(token);
        Integer userids = verify.getClaim("userid").asInt();
        System.out.println("token携带的用户id" + userids);

        //传入本人的用户id
        List<VideObjet> videos=videoServer.attentionlist(userids);
        Op_Video op_video1=new Op_Video();
        Map<String,Object> map=new HashMap<>();
        for (VideObjet op_video:videos){
            //getVideoId 视频id ,getVideoCount 视频点赞数
            System.out.println("视频id"+op_video.getVideoId()+"视频点赞数"+op_video.getVideoCount());
            map.put(""+op_video.getVideoId(),""+op_video.getVideoCount());
        }
        redisTemplate.opsForHash().putAll("H_v",map);
        //redisTemplate.opsForHash().putAll("V-",)
        return R.ok().data("v",videos);
    }
    //添加喜欢数
    @RequestMapping("/addlike")
    public R addlike(@RequestParam String vid,@RequestParam Map<String,Object> maps){
        System.out.println("添加到消息map"+maps);
        rabbitTemplate.convertAndSend(
                MyRabbitMQConfig.giveSTORY_EXCHANGE, MyRabbitMQConfig.giveSTORY_ROUTING_KEY,maps);
        Map<String,Object> map=new HashMap<>();
        System.out.println("视频id"+vid);
        System.out.println("添加喜欢数");
        String count=redisTemplate.opsForHash().increment("H_v", vid,1).toString();
        System.out.println("redis操作后的数量"+count);
        map.put("videoId",vid);
        map.put("videoCount",count);
        //LOGGER.info("参加秒杀的用户是：{}，秒杀的商品是：{}", username, stockName);
        rabbitTemplate.convertAndSend(
                MyRabbitMQConfig.STORY_EXCHANGE, MyRabbitMQConfig.STORY_ROUTING_KEY,map);
        return R.ok();
    }
    //递减
    @RequestMapping("/derlike")
    public R derlike(@RequestParam String vid){
        Map<String,Object> map=new HashMap<>();
        System.out.println("取消喜欢");
        String count=redisTemplate.opsForHash().increment("H_v", vid,-1).toString();
        map.put("videoId",vid);
        map.put("videoCount",count);
        rabbitTemplate.convertAndSend(
                MyRabbitMQConfig.STORY_EXCHANGE, MyRabbitMQConfig.STORY_ROUTING_KEY,map);
        return R.ok();
    }

    /**
     * 监听库存消息队列,喜欢数量加一
     * 数据库操作
     * @param map
     */
    @RabbitListener(queues = MyRabbitMQConfig.STORY_QUEUE)
    public void decrByStock(Map<String,Object> map) {
        System.out.println("监听消息队列"+map);
        int num=videoServer.updatecount(map);
        if (num>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        /**
         *调用数据库service给数据库对应商品库存减一
         */
        //数据库根据视频id修改视频的喜欢数量
    }


    //测试获取路径
    @PostMapping("/ceshi")
    public String ceshi(@RequestPart("file") MultipartFile file){
        System.out.println("路径"+file);
        return "成功";
    }

    //上传视频
    //上传视频到阿里云
    @PostMapping("/ceshishdf")
    public R uploadAlyiVideo(@RequestPart("file") MultipartFile file,
                             @RequestParam int userdis,
                             @RequestParam String vname)
                             throws ClientException {
        System.out.println("用户id"+userdis+"vname"+vname);
        System.out.println("文件"+file);
        //返回上传视频id
        String videoId = videoServer.uploadVideoAly(file);
        System.out.println("id是否是空"+videoId);
        if(videoId!=null){
            //根据id查询视频点播的url
            System.out.println("进来了..");
            try {
                System.out.println("try进来了");
                //查询视频的url
                System.out.println("视频地址"+videoId);
                String url=videoServer.selecturl(videoId);
                System.out.println("地址"+url);
                System.out.println("添加成功");
                Map<String,Object> map=new HashMap<>();
                map.put("userId",userdis);
                map.put("videoUrl",url);
                map.put("videoDescript",vname);
                map.put("oosId",videoId);
                int num=videoServer.invideo(map);
                if (num>0){
                    System.out.println("添加到数据成功");
                    redisUtil.del("user");
                    redisUtil.del(""+userdis);
                    return R.ok().message(true);
                }
            }catch (Exception e){

                System.out.println("出错了...");
                return R.error().message(false);
            }
        }else{
            System.out.println("添加失败");
            return R.error().message(false);
        }
        System.out.println("文件是否上传成功"+videoId);
        return R.error().message(false);
    }

    //查询视频的url
    @RequestMapping("/select")
    public  String url() throws ClientException {
        try {
            //查询视频的url
            String url = vodService.selecturl("046fc204565d48a6a0734a299940360f");
            System.out.println("地址" + url);
            return url;
        } catch (Exception e) {
            return "视频不存在";
        }
    }
}