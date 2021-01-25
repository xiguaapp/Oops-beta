package com.example.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitMQConfig {

    //库存交换机
    public static final String STORY_EXCHANGE = "STORY_EXCHANGE";

    //库存队列
    public static final String STORY_QUEUE = "STORY_QUEUE";

    //库存路由键
    public static final String STORY_ROUTING_KEY = "STORY_ROUTING_KEY";


    //点赞交换机
    public static final String giveSTORY_EXCHANGE = "giveSTORY_EXCHANGE";

    //点赞队列
    public static final String giveSTORY_QUEUE = "giveSTORY_QUEUE";

    //点赞路由键
    public static final String giveSTORY_ROUTING_KEY = "giveSTORY_ROUTING_KEY";


    //关注交换机
    public static final String fansSTORY_EXCHANGE = "fansSTORY_EXCHANGE";

    //关注队列
    public static final String fansSTORY_QUEUE = "fansSTORY_QUEUE";

    //关注路由键
    public static final String fansSTORY_ROUTING_KEY = "fansSTORY_ROUTING_KEY";



    //评论交换机
    public static final String commentSTORY_EXCHANGE = "commentSTORY_EXCHANGE";

    //评论队列
    public static final String commentSTORY_QUEUE = "commentSTORY_QUEUE";

    //评论路由键
    public static final String commentSTORY_ROUTING_KEY = "commentSTORY_ROUTING_KEY";


    //礼物交换机
    public static final String  gifSTORY_EXCHANGE = " gifSTORY_EXCHANGE";

    //礼物队列
    public static final String  gifSTORY_QUEUE = " gifSTORY_QUEUE";

    //礼物路由键
    public static final String  gifSTORY_ROUTING_KEY = " gifSTORY_ROUTING_KEY";


    //添加到背包
    //礼物背包交换机
    public static final String  beibaogifSTORY_EXCHANGE = "beibaogifSTORY_EXCHANGE";

    //礼物背包队列
    public static final String  beibaogifSTORY_QUEUE = "beibaogifSTORY_QUEUE";

    //礼物背包路由键
    public static final String  beibaogifSTORY_ROUTING_KEY = "beibaogifSTORY_ROUTING_KEY";



    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }




    //创建库存交换机
    @Bean
    public Exchange getStoryExchange() {
        return ExchangeBuilder.directExchange(STORY_EXCHANGE).durable(true).build();
    }

    //创建库存队列
    @Bean
    public Queue getStoryQueue() {
        return new Queue(STORY_QUEUE);
    }

    //库存交换机和库存队列绑定
    @Bean
    public Binding bindStory() {
        return BindingBuilder.bind(getStoryQueue()).to(getStoryExchange()).with(STORY_ROUTING_KEY).noargs();
    }


    /*-----------------------------------------------------------------*/

    //点赞交换机
    @Bean
    public Exchange  givegetStoryExchange() {
        return ExchangeBuilder.directExchange(giveSTORY_EXCHANGE).durable(true).build();
    }

    //创建点赞队列
    @Bean
    public Queue  givegetStoryQueue() {
        return new Queue( giveSTORY_QUEUE);
    }

    //点赞交换机和点赞队列绑定
    @Bean
    public Binding  givebindStory() {
        return BindingBuilder.bind(givegetStoryQueue()).to(givegetStoryExchange()).with( giveSTORY_ROUTING_KEY).noargs();
    }

    /*-----------------------------------------------------------------*/


    //关注交换机
    @Bean
    public Exchange  fansgetStoryExchange() {
        return ExchangeBuilder.directExchange(fansSTORY_EXCHANGE).durable(true).build();
    }
    //关注点赞队列
    @Bean
    public Queue  fansgetStoryQueue() {
        return new Queue( fansSTORY_QUEUE);
    }

    //关注交换机和关注队列绑定
    @Bean
    public Binding  fansbindStory() {
        return BindingBuilder.bind(fansgetStoryQueue()).to(fansgetStoryExchange()).with( fansSTORY_ROUTING_KEY).noargs();
    }

    /*-----------------------------------------------------------------*/

    //评论交换机
    @Bean
    public Exchange  commentgetStoryExchange() {
        return ExchangeBuilder.directExchange(commentSTORY_EXCHANGE).durable(true).build();
    }
    //评论点赞队列
    @Bean
    public Queue  commentgetStoryQueue() {
        return new Queue( commentSTORY_QUEUE);
    }

    //评论交换机和关注队列绑定
    @Bean
    public Binding  commentbindStory() {
        return BindingBuilder.bind(commentgetStoryQueue()).to(commentgetStoryExchange()).with( commentSTORY_ROUTING_KEY).noargs();
    }

    /*-----------------------------------------------------------------*/

    //礼物交换机
    @Bean
    public Exchange  gifgetStoryExchange() {
        return ExchangeBuilder.directExchange(gifSTORY_EXCHANGE).durable(true).build();
    }
    //礼物点赞队列
    @Bean
    public Queue  gifgetStoryQueue() {
        return new Queue( gifSTORY_QUEUE);
    }

    //礼物交换机和礼物队列绑定
    @Bean
    public Binding  gifbindStory() {
        return BindingBuilder.bind(gifgetStoryQueue()).to(gifgetStoryExchange()).with( gifSTORY_ROUTING_KEY).noargs();
    }

    /*----------------------------------------------------*/
}