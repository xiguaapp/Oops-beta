//package com.example.PayServer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import java.util.List;
//
//@Service
//public class OrdersService {
//    @Autowired
//    OrdersMapper ordersMapper;
//    public void createOrder(Orders orders){
//        ordersMapper.insert(orders);
//    }
//    public Orders selectByPrimaryKey(String id){
//        return ordersMapper.selectByPrimaryKey(id);
//    }
//    //修改订单状态
//    public void updateorder(Orders orders){
//        ordersMapper.updateorder(orders);
//    }
//    public List<Orders> lookallOrder(){
//        return ordersMapper.lookallOrder();
//    }
//}
