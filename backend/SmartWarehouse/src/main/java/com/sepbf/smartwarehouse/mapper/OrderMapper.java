package com.sepbf.smartwarehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sepbf.smartwarehouse.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
/**
 * @author hanjiang
 * @version 1.0
 * @date 2023/4/14 14:52
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}
