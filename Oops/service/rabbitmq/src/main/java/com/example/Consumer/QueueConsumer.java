package com.example.Consumer;


import com.example.config.MyRabbitMQConfig;
import com.example.po.comment;
import com.example.po.fans;
import lombok.Data;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.example.po.give;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

@Component
// 监听pibigstar队列
//@RabbitListener(queues = QueueRabbit.QUEUE_NAME)
public class QueueConsumer {

    @Autowired
    private MongoTemplate mongoTemplate;
    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

    //点赞
    @RabbitListener(queues = MyRabbitMQConfig.giveSTORY_QUEUE)
    public void decrByStock(Map<String,Object> map) {
        System.out.println("当前日期:"+df.format(new Date()));// new Date()为获取当前系统时间
        //点赞信息添加到mongodb
        give give=new give();
        give.setZjid(map.get("maps[userId]"));
        give.setUserid(map.get("userid"));
        give.setUserName(map.get("maps[userName]"));
        give.setHead(map.get("maps[head]"));
        give.setVid(map.get("vid"));
        give.setVurl(map.get("vurl"));
        give.setDatime(df.format(new Date()));
        mongoTemplate.save(give);
        System.out.println("map"+map);
        System.out.println("点赞监听消息队列" + map.get("vid")+":"+map.get("maps[userId]"));
    }

    //关注
    @RabbitListener(queues = MyRabbitMQConfig.fansSTORY_QUEUE)
    public void fansdecrByStock(Map<String,Object> map) {
        System.out.println("当前日期:"+df.format(new Date()));// new Date()为获取当前系统时间
        System.out.println("map"+map);
        //关注信息添加到mongodb
        System.out.println("关注信息添加到mongodb");
        fans fans=new fans();
        fans.setUserid(map.get("userlist[userId]"));
        fans.setZjid(map.get("userid"));
        fans.setUserName(map.get("userlist[userName]"));
        fans.setHead(map.get("userlist[head]"));
        fans.setDatime(df.format(new Date()));
        mongoTemplate.save(fans);
    }
    private  Object userid;
    //用户名称
    private Object userName;
    //用户头像url
    private  Object head;
    //视频id
    private  Object vid;
    //视频地址url
    private  Object vurl;
    //评论内容
    private  Object content;
    //评论时间
    private  String datime;

    //评论
    @RabbitListener(queues = MyRabbitMQConfig.commentSTORY_QUEUE)
    public void commentdecrByStock(Map<String,Object> map) {
        System.out.println("当前日期:"+df.format(new Date()));// new Date()为获取当前系统时间
        System.out.println("map"+map);
        //关注信息添加到mongodb
        comment comment=new comment();
        comment.setUserid(map.get("userlist[userId]"));
        comment.setUserName(map.get("userlist[userName]"));
        comment.setHead(map.get("userlist[head]"));
        comment.setVid(map.get("vid"));
        comment.setVurl(map.get("vurl"));
        comment.setContent(map.get("msg"));
        comment.setDatime(df.format(new Date()));
        mongoTemplate.save(comment);
        }
}