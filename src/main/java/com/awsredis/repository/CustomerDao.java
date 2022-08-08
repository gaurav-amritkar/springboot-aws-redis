package com.awsredis.repository;

import com.awsredis.model.Customer;
import com.awsredis.model.User;

import java.util.List;

public interface CustomerDao {
    boolean saveCustomer(Customer customer);

    List<Customer> fetchAllCustomer();

    Customer fetchCustomerById(Long id);

    boolean deleteCustomer(Long id);

    boolean updateCustomer(Long id, Customer customer);
}
