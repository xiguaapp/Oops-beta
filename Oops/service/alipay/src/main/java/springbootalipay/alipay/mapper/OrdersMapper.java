package springbootalipay.alipay.mapper;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.core.annotation.Order;
import springbootalipay.alipay.entity.Orders;
import java.util.List;

public interface OrdersMapper {

    //这里为了简单不判断订单是否创建成功
    void insert(Orders record);
    //查询订单
    Orders selectByPrimaryKey(String id);
    //修改订单状态
    void updateorder(Orders orders);

    List<Orders> lookallOrder();
}