package com.sepbf.smartwarehouse.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sepbf.smartwarehouse.mapper.CustomerMapper;
import com.sepbf.smartwarehouse.pojo.Customer;
import com.sepbf.smartwarehouse.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * CustomerService的实现类
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    /**
     * 自动注入CustomerMapper对象
     */
    @Resource
    private CustomerMapper customerMapper;

    /**
     * 根据ID查询Customer信息
     *
     * @param id Customer的ID
     * @return 查询到的Customer对象，如果查询失败返回null
     */
    @Override
    public Customer getCustomerById(Integer id) {
        return customerMapper.selectById(id);
    }

    /**
     * 新增一条Customer记录
     *
     * @param customer 要新增的Customer对象
     * @return 返回值为true表示新增成功，false表示新增失败
     */
    @Override
    public boolean addCustomer(Customer customer) {
        return customerMapper.insert(customer) > 0;
    }

    /**
     * 更新一条Customer记录
     *
     * @param customer 要更新的Customer对象
     * @return 返回值为true表示更新成功，false表示更新失败
     */
    @Override
    public boolean updateCustomer(Customer customer) {
        return customerMapper.updateById(customer) > 0;
    }

    /**
     * 根据ID删除一条Customer记录
     *
     * @param id Customer的ID
     * @return 返回值为true表示删除成功，false表示删除失败
     */
    @Override
    public boolean deleteCustomer(Integer id) {
        return customerMapper.deleteById(id) > 0;
    }

}

