package com.awsredis.service;

import com.awsredis.model.Customer;
import com.awsredis.model.User;
import com.awsredis.repository.CustomerDao;
import com.awsredis.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean saveCustomer(Customer customer) {
        return customerDao.saveCustomer(customer);
    }

    @Override
    public List<Customer> fetchAllCustomer() {
        return customerDao.fetchAllCustomer();
    }

    @Override
    public Customer fetchCustomerById(Long id) {
        return customerDao.fetchCustomerById(id);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return customerDao.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Long id, Customer customer) {
        return customerDao.updateCustomer(id,customer);
    }
}
