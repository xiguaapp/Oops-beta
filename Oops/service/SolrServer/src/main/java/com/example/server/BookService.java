package com.example.server;

import com.example.po.Book;
import com.example.po.UserVideo;

import java.util.List;

public interface BookService {

    public List<Book> findAll();


    public  List<UserVideo> allsolr();

}
