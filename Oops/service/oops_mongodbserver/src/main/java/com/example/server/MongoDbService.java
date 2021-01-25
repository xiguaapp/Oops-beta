//package com.example.server;
//
//import com.example.po.Book;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//import java.util.regex.Pattern;
//
//@Service
//public class MongoDbService {
//
//    private static final Logger logger = LoggerFactory.getLogger(MongoDbService.class);
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    /**
//     * 保存对象
//     * @return
//     *    id;     //弹幕id
//     *    userid;//用户id
//     *    text;   //弹幕内容
//     *    head;   //用户头像
//     *    createTime;//评论时间
//     */
//    public String saveObj() {
////        Book book=new Book();
////        book.setUserid(2);
////        book.setVideo_id(3);
////        book.setText("不错不错");
////        book.setHead("img");
////        book.setCreateTime(new Date());
////        System.out.println("book"+book);
////        mongoTemplate.save(book);
//        return "添加成功";
//    }
//
////    public static void main(String[] args) {
////        MongoTemplate mongoTemplate = null;
////        Book book=new Book();
////        book.setUserid(2);
////        book.setVideo_id(3);
////        book.setText("不错不错");
////        book.setHead("img");
////        book.setCreateTime(new Date());
////        System.out.println("book"+book);
////        mongoTemplate.save(book);
////        mongoTemplate.findAll(Book.class);
////    }
//
//        /**
//         * 查询所有
//         * @return
//         */
//    public List<Book> findAll() {
//        return mongoTemplate.findAll(Book.class);
//    }
//
//    /***
//     * 根据id查询
//     * @param id
//     * @return
//     */
//    public Book getBookById(String id) {
//        Query query = new Query(Criteria.where("_id").is(id));
//        return mongoTemplate.findOne(query, Book.class);
//    }
//
//    /**
//     * 根据视频id查询弹幕
//     * @param video_id
//     * @return
//     */
//    public List<Book> getBookByName(int video_id) {
//        Query query = new Query(Criteria.where("video_id").is(video_id));
//        return mongoTemplate.find(query, Book.class);
//    }
//
//    /**
//     * 更新对象
//     *
//     * @param book
//     * @return
//     */
////    public String updateBook(Book book) {
////        Query query = new Query(Criteria.where("_id").is(book.getId()));
////        Update update = new Update().set("publish", book.getPublish()).set("info", book.getInfo()).set("updateTime",
////                new Date());
////        // updateFirst 更新查询返回结果集的第一条
////        mongoTemplate.updateFirst(query, update, Book.class);
////        // updateMulti 更新查询返回结果集的全部
////        // mongoTemplate.updateMulti(query,update,Book.class);
////        // upsert 更新对象不存在则去添加
////        // mongoTemplate.upsert(query,update,Book.class);
////        return "success";
////    }
//
//    /***
//     * 删除对象
//     * @param book
//     * @return
//     */
//    public String deleteBook(Book book) {
//        mongoTemplate.remove(book);
//        return "success";
//    }
//
//    /**
//     * 根据id删除
//     *
//     * @param id
//     * @return
//     */
//    public String deleteBookById(String id) {
//        // findOne
//        Book book = getBookById(id);
//        // delete
//        deleteBook(book);
//        return "success";
//    }
//
//    /**
//     * 模糊查询
//     * @param search
//     * @return
//     */
//    public List<Book> findByLikes(String search){
//        Query query = new Query();
//        Criteria criteria = new Criteria();
//        //criteria.where("name").regex(search);
//        Pattern pattern = Pattern.compile("^.*" + search + ".*$" , Pattern.CASE_INSENSITIVE);
//        criteria.where("name").regex(pattern);
//        List<Book> lists = mongoTemplate.findAllAndRemove(query, Book.class);
//        return lists;
//    }
//
//}
package com.example.server;

import com.example.client.VideoClient;
import com.example.entity.Home;
import com.example.po.*;
import com.mongodb.client.MongoCollection;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
@Slf4j
@Service
public class MongoDbService {

    private static final Logger logger = LoggerFactory.getLogger(MongoDbService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存对象
     * @return
     *    id;     //弹幕id
     *    userid;//用户id
     *    text;   //弹幕内容
     *    head;   //用户头像
     *    createTime;//评论时间
     */
    public String saveObj() {
//        Book book=new Book();
//        book.setUserid(2);
//        book.setVideo_id(3);
//        book.setText("不错不错");
//        book.setHead("img");
//        book.setCreateTime(new Date());
//        System.out.println("book"+book);
//        mongoTemplate.save(book);
        return "添加成功";
    }

//    public static void main(String[] args) {
//        MongoTemplate mongoTemplate = null;
//        Book book=new Book();
//        book.setUserid(2);
//        book.setVideo_id(3);
//        book.setText("不错不错");
//        book.setHead("img");
//        book.setCreateTime(new Date());
//        System.out.println("book"+book);
//        mongoTemplate.save(book);
//        mongoTemplate.findAll(Book.class);
//    }

    /**
     * 查询所有
     * @return
     */
    public List<Book> findAll() {
        return mongoTemplate.findAll(Book.class);
    }

    /***
     * 根据id查询
     * @param id
     * @return
     */
    public Book getBookById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Book.class);
    }

    /**
     * 根据视频id查询弹幕
     * @param video_id
     * @return
     */
    public List<Book> getBookByName(int video_id) {
        Query query = new Query(Criteria.where("video_id").is(video_id));
        return mongoTemplate.find(query, Book.class);
    }

    /**
     * 根据用户id查询关注
     * @param user_id
     * @return
     */
    public List<fans> getfansByName(int user_id) {
        System.out.println("关注的id"+user_id);
        Query query = new Query(Criteria.where("userid").is(user_id));
        return mongoTemplate.find(query,fans.class);
    }

    /**
     * 根据用户id查询点赞
     * @param user_id
     * @return
     */
    public List<give> getgiveByName(int user_id) {
        Query query = new Query(Criteria.where("userid").is(user_id));
        return mongoTemplate.find(query, give.class);
    }

    /**
     * 根据用户id查询评论
     * @param user_id
     * @return
     */
    public List<comment> getcommentByName(int user_id) {
        Query query = new Query(Criteria.where("userid").is(user_id));
        return mongoTemplate.find(query, comment.class);
    }

    /**
     * 更新对象
     *
     * @param book
     * @return
     */
//    public String updateBook(Book book) {
//        Query query = new Query(Criteria.where("_id").is(book.getId()));
//        Update update = new Update().set("publish", book.getPublish()).set("info", book.getInfo()).set("updateTime",
//                new Date());
//        // updateFirst 更新查询返回结果集的第一条
//        mongoTemplate.updateFirst(query, update, Book.class);
//        // updateMulti 更新查询返回结果集的全部
//        // mongoTemplate.updateMulti(query,update,Book.class);
//        // upsert 更新对象不存在则去添加
//        // mongoTemplate.upsert(query,update,Book.class);
//        return "success";
//    }

    /***
     * 删除对象
     * @param book
     * @return
     */
    public String deleteBook(Book book) {
        mongoTemplate.remove(book);
        return "success";
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    public String deleteBookById(String id) {
        // findOne
        Book book = getBookById(id);
        // delete
        deleteBook(book);
        return "success";
    }

    /**
     * 模糊查询
     * @param search
     * @return
     */
    public List<Book> findByLikes(String search){
        Query query = new Query();
        Criteria criteria = new Criteria();
        //criteria.where("name").regex(search);
        Pattern pattern = Pattern.compile("^.*" + search + ".*$" , Pattern.CASE_INSENSITIVE);
        criteria.where("name").regex(pattern);
        List<Book> lists = mongoTemplate.findAllAndRemove(query, Book.class);
        return lists;
    }
    //这里就是算法类 用于筛选获取到的数据 最终去首页的集合
    @Autowired
    VideoClient videoClient;
    public void save2Mongo(){
        log.info("save2Mongo start");
        List<VideObjet> listByCount = videoClient.getListByCount();
        List<VideObjet> listByWeight = videoClient.getListByWeight();
        //以下是对两个集合的筛选 如果相同则 入队列 不相同则进第二队列
        List<VideObjet> op_videos = listByCount.stream()
                .filter(
                        t1 -> listByWeight.stream().filter(t2 -> t1.getUserId() == t2.getUserId()).count() <= 1
                )
                .collect(Collectors.toList());
        log.info("op_videos:{}",op_videos);
        op_videos.addAll(listByCount);
        List<VideObjet> videos = op_videos
                //collectingAndThen收集然后在
                .stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getUserId()))), ArrayList::new))
                .stream().sorted(Comparator.comparing(VideObjet::getWeight)).collect(Collectors.toList());
        List<Home> list=new ArrayList<>();
        videos.stream().forEach(s->{
            Home home=new Home();
            BeanUtils.copyProperties(s,home);
            list.add(home);
        });
        log.info("list:{}",list);
        mongoTemplate.insert(list,Home.class);

    }
    public void delete(){
        mongoTemplate.dropCollection(Home.class);
    }
}

