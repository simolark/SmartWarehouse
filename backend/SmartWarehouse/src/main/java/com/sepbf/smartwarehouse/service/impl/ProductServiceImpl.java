package com.sepbf.smartwarehouse.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.ProductMapper;
import com.sepbf.smartwarehouse.pojo.Product;
import com.sepbf.smartwarehouse.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * ProductService的实现类
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    /**
     * 自动注入ProductMapper对象
     */
    @Resource
    private ProductMapper productMapper;

    /**
     * 根据ID查询Product信息
     *
     * @param id Product的ID
     * @return 查询到的Product对象，如果查询失败返回null
     */
    @Override
    public Product getProductById(Integer id) {
        return productMapper.selectById(id);
    }

    /**
     * 新增一条Product记录
     *
     * @param product 要新增的Product对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    @Override
    public boolean addProduct(Product product) {
        return productMapper.insert(product) > 0;
    }

    /**
     * 更新一条Product记录
     *
     * @param product 要更新的Product对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    @Override
    public boolean updateProduct(Product product) {
        return productMapper.updateById(product) > 0;
    }

    /**
     * 根据ID删除一条Product记录
     *
     * @param id Product的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    @Override
    public boolean deleteProduct(Integer id) {
        return productMapper.deleteById(id) > 0;
    }
}

