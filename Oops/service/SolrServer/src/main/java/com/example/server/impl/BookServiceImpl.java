package com.example.server.impl;

import com.example.dao.BookDao;
import com.example.po.Book;
import com.example.po.UserVideo;
import com.example.server.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<UserVideo> allsolr() {
        return bookDao.allsolr();
    }


}
