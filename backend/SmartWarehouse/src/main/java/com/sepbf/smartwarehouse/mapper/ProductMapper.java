package com.sepbf.smartwarehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sepbf.smartwarehouse.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author HeYi
 * @version 1.0
 * @date 2023/3/16 22:11
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
