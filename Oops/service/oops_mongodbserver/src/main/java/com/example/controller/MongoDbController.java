package com.example.controller;

import com.example.po.Book;
import com.example.server.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MongoDbController {
    @Autowired
    private MongoDbService mongoDbService;

    //保存弹幕
    @PostMapping("/mongo/save")
    public String saveObj() {
        System.out.println("进入...");
        return mongoDbService.saveObj();
    }

   //查询所有弹幕
    @GetMapping("/mongo/findAll")
    public List<Book> findAll() {
        return mongoDbService.findAll();
    }

    //根据id查询
    @GetMapping("/mongo/findOne")
    public Book findOne(@RequestParam String id) {
        return mongoDbService.getBookById(id);
    }

    //根据视频id查询
    @GetMapping("/mongo/findOneByName")
    public List<Book> findOneByName(@RequestParam int video_id) {
        return mongoDbService.getBookByName(video_id);
    }

//    //更新对象
//    @PostMapping("/mongo/update")
//    public String update(@RequestBody Book book) {
//        return mongoDbService.updateBook(book);
//    }

    //删除对象
    @PostMapping("/mongo/delOne")
    public String delOne(@RequestBody Book book) {
        return mongoDbService.deleteBook(book);
    }

    //根据id删除
    @GetMapping("/mongo/delById")
    public String delById(@RequestParam String id) {
        return mongoDbService.deleteBookById(id);
    }

    //模糊查询
    @GetMapping("/mongo/findlikes")
    public List<Book> findByLikes(@RequestParam String search) {
        return mongoDbService.findByLikes(search);
    }
}
