package springbootalipay.alipay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootalipay.alipay.entity.Flow;
import springbootalipay.alipay.mapper.FlowMapper;

@Service
public class FlowService {
    @Autowired
    FlowMapper flowMapper;
    public int insert(Flow record){
        return flowMapper.insert(record);
    }
    public Flow selectByPrimaryKey(String id){
        return flowMapper.selectByPrimaryKey(id);
    }
}
