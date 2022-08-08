package com.awsredis.repository;

import com.awsredis.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "CUSTOMER";

    @Override
    public boolean saveCustomer(Customer customer) {
        try {
            redisTemplate.opsForHash().put(KEY, customer.getCustId().toString(), customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Customer> fetchAllCustomer() {
        List<Customer> customers;
        customers = redisTemplate.opsForHash().values(KEY);
        return  customers;
    }

    @Override
    public Customer fetchCustomerById(Long id) {
        Customer customer;
        customer = (Customer) redisTemplate.opsForHash().get(KEY,id.toString());
        return customer;
    }

    @Override
    public boolean deleteCustomer(Long id) {
        try {
            redisTemplate.opsForHash().delete(KEY,id.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Long id, Customer customer) {
        try {
            redisTemplate.opsForHash().put(KEY, id, customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
