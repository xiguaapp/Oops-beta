//package com.example.message;
//
//import org.springframework.amqp.core.ExchangeTypes;
//import org.springframework.amqp.rabbit.annotation.Exchange;
//import org.springframework.amqp.rabbit.annotation.Queue;
//import org.springframework.amqp.rabbit.annotation.QueueBinding;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//public class MessageConsumerService {
//
////    //监听 直连
//     //@RabbitListener(queues = "q11")
////    @RabbitListener(bindings = {@QueueBinding(
////            value = @Queue(value = "${mq.config.queue}",durable = "true",autoDelete = "true"),
////            exchange = @Exchange(value = "${mq.config.exchange}",autoDelete = "true",type = ExchangeTypes.DIRECT),
////            key = "${mq.config.routing}"
////    )}
////    )
////
////    public void receive1(String msg){
////        System.out.println("receive1"+msg);
////    }
////
////    //监听 直连
////    @RabbitListener(bindings = {@QueueBinding(
////            value = @Queue(value = "q12",durable ="true",autoDelete ="true"),
////            exchange = @Exchange(value = "${mq.config.exchange}",autoDelete ="true",type = ExchangeTypes.DIRECT),
////            key = "${mq.config.routing}"
////    )}
////    )
////    public void receive2(String msg){
////        System.out.println("receive2"+msg);
////    }
////
////    //监听 广播
////    @RabbitListener(bindings = {@QueueBinding(
////            value = @Queue(value = "q13",durable ="true",autoDelete ="true"),
////            exchange = @Exchange(value = "fanout",autoDelete ="true",type = ExchangeTypes.FANOUT)
////    )}
////    )
////    public void receive13(Map<String,Object> msg){
////        System.out.println("receive1"+msg);
////    }
////
////    //监听 广播
////    @RabbitListener(bindings = {@QueueBinding(
////            value = @Queue(value = "q14",durable ="true",autoDelete ="true"),
////            exchange = @Exchange(value = "fanout",autoDelete ="true",type = ExchangeTypes.FANOUT)
////    )}
////    )
////    public void receive14(Map<String,Object> msg){
////        System.out.println("receive2"+msg);
////    }
////
////    //监听 主题
////    @RabbitListener(bindings = {@QueueBinding(
////            value = @Queue(value = "q15",durable = "true",autoDelete = "true"),
////            exchange = @Exchange(value = "topic",autoDelete = "true",type = ExchangeTypes.TOPIC),
////            key = "#.k4.*"
////    )}
////    )
////    public void receive15(Object msg){
////        System.out.println("receive2"+msg);
////        throw new RuntimeException("异常");
////    }
//
//
//    //监听 主题
//    @RabbitListener(bindings = {@QueueBinding(
//            value = @Queue(value = "q16",durable = "true",autoDelete = "true"),
//            exchange = @Exchange(value = "topic",autoDelete = "true",type = ExchangeTypes.TOPIC),
//            key = "#.k4.*"
//    )}
//    )
//    public void receive16(Object msg){
//        System.out.println("receive2"+msg);
//    }
//
//}
