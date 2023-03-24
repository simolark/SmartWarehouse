package com.sepbf.smartwarehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sepbf.smartwarehouse.pojo.Customer;

/**
 * CustomerService接口，继承自MyBatis-Plus的IService接口
 */
public interface CustomerService extends IService<Customer> {

    /**
     * 根据ID查询Customer信息
     *
     * @param id Customer的ID
     * @return 查询到的Customer对象，如果查询失败返回null
     */
    Customer getCustomerById(Integer id);

    /**
     * 新增一条Customer记录
     *
     * @param customer 要新增的Customer对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    boolean addCustomer(Customer customer);

    /**
     * 更新一条Customer记录
     *
     * @param customer 要更新的Customer对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    boolean updateCustomer(Customer customer);

    /**
     * 根据ID删除一条Customer记录
     *
     * @param id Customer的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    boolean deleteCustomer(Integer id);
}

