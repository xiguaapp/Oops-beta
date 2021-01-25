package springbootalipay.alipay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootalipay.alipay.entity.Product;
import springbootalipay.alipay.mapper.ProductMapper;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;
    public List<Product> selectAll(){
        return productMapper.selectAll();
    }
    public Product selectByPrimaryKey(String id){
        return productMapper.selectByPrimaryKey(id);
    }
}
