package com.example.controller;

import com.example.commonutils.R;
import com.example.config.MyRabbitMQConfig;
import com.example.po.Book;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/videoserver/filtration")
public class CommentController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //添加评论
    @RequestMapping("/addcomment")
    public R addcomment(@RequestParam String name,@RequestParam String head,
                        @RequestParam String msg,@RequestParam Integer vid,
                        @RequestParam Map<String,Object> userlist){

        System.out.println("用户..."+userlist);
        rabbitTemplate.convertAndSend(
                MyRabbitMQConfig.commentSTORY_EXCHANGE, MyRabbitMQConfig.commentSTORY_ROUTING_KEY,userlist);
        //生成1位随机数
        int code =((int)((Math.random()*9+1)*1));
        System.out.println("时间随机"+code);
        System.out.println("用户头像"+head);
        System.out.println("用户名"+name);
        System.out.println("用户的评论"+msg);
        System.out.println("视频id"+vid);
        Book book=new Book();
        book.setMsg(msg);
        book.setAvatar(head);
        book.setTime(code);
        book.setBarrageStyle("red");
        book.setName(name);
        book.setVid(vid);
        mongoTemplate.save(book);
        return R.ok();
    }
}
