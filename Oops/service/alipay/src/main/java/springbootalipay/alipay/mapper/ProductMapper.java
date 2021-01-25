package springbootalipay.alipay.mapper;

import springbootalipay.alipay.entity.Product;
import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(Product record);

    Product selectByPrimaryKey(String id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);
}