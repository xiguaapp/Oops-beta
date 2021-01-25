package springbootalipay.alipay.mapper;

import springbootalipay.alipay.entity.Flow;
import java.util.List;

public interface FlowMapper {
    int deleteByPrimaryKey(String id);

    int insert(Flow record);

    Flow selectByPrimaryKey(String id);

    List<Flow> selectAll();

    int updateByPrimaryKey(Flow record);
}