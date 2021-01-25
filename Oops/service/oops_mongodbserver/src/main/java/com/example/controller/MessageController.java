package com.example.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.commonutils.JwtUtils;
import com.example.commonutils.R;
import com.example.entity.Home;
import com.example.po.Book;
import com.example.po.comment;
import com.example.po.fans;
import com.example.po.give;
import com.example.server.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MessageController {

    @Autowired
    private MongoDbService mongoDbService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/fans")
    //查询关注 HttpServletRequest request
    public R fans(HttpServletRequest request) {
        System.out.println("关注");
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("用户id"+userids);
       /*is(Stirng类型)*/
        Query query = new Query(Criteria.where("zjid").is(""+userids));
        List<fans> fansList=mongoTemplate.find(query,fans.class);
        System.out.println("mongodb查询的值"+fansList);
        return R.ok().message(fansList);
    };
    @PostMapping("/comment")
    //查询评论
    public R comment(HttpServletRequest request) {
        System.out.println("评论");
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        System.out.println("查询评论");
        Query query = new Query(Criteria.where("userid").is(""+userids));
        List<comment> commentList=mongoTemplate.find(query,comment.class);
        return R.ok().message(commentList);
    };

    @RequestMapping("/give")
    //查询点赞
    public R give(HttpServletRequest request) {
        System.out.println("点赞");
        String token=request.getHeader("token");
        DecodedJWT verify= JwtUtils.verify(token);
        Integer userids=verify.getClaim("userid").asInt();
        Query query = new Query(Criteria.where("zjid").is(""+userids));
        List<give> giveList=mongoTemplate.find(query,give.class);
        return R.ok().message(giveList);
    };


        //查询推荐视频
        @RequestMapping("/recommend")
        public R recommend(){
        System.out.println("查询所有");
        List<Home> homeList=mongoTemplate.findAll(Home.class);
        System.out.println("homeList"+homeList);
        return R.ok().message(homeList);
    }
}