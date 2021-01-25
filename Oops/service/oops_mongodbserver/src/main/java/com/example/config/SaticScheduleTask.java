package com.example.config;

import com.example.server.MongoDbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class SaticScheduleTask {
    @Autowired
    MongoDbService mongoDbService;
//  @Scheduled(cron = "0 0 12 * * ?")
    @Scheduled(cron = "0 0/2 * * * ?")
    //或直接指定时间间隔，例如 每天12点更新一次
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        mongoDbService.delete();
        log.info("先清空mogodb");
        mongoDbService.save2Mongo();
        log.info("现在时间{},正在执行mongodb的定时任务", LocalDateTime.now());
    }
}