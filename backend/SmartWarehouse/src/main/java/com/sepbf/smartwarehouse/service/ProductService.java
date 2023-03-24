package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.Product;


/**
 * ProductService接口，继承自MyBatis-Plus的IService接口
 */
public interface ProductService extends IService<Product> {

    /**
     * 根据ID查询Product信息
     *
     * @param id Product的ID
     * @return 查询到的Product对象，如果查询失败返回null
     */
    Product getProductById(Integer id);

    /**
     * 新增一条Product记录
     *
     * @param product 要新增的Product对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    boolean addProduct(Product product);

    /**
     * 更新一条Product记录
     *
     * @param product 要更新的Product对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    boolean updateProduct(Product product);

    /**
     * 根据ID删除一条Product记录
     *
     * @param id Product的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    boolean deleteProduct(Integer id);
}

