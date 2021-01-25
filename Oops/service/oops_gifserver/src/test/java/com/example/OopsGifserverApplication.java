package com.example;


import com.example.server.GiftServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@SpringBootTest
class SolrserverApplicationTests {

    @Autowired
    GiftServer giftServer;

    @Test
    void contextLoads() {
        giftServer.giftlist();
    }

    }
