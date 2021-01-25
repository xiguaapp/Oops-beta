package com.example.dao;

import com.example.po.Book;
import com.example.po.UserVideo;

import java.util.List;

public interface BookDao {

    public List<Book> findAll();

    public  List<UserVideo> allsolr();

}
