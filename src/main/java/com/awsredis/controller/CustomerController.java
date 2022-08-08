package com.awsredis.controller;

import com.awsredis.model.Customer;
import com.awsredis.model.User;
import com.awsredis.service.CustomerService;
import com.awsredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
        boolean result = customerService.saveCustomer(customer);
        if(result)
            return ResponseEntity.ok(customer.getCustFirstName() + " " + customer.getCustLastName() + " " + "Customer Created Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> fetchAllCustomer() {
        List<Customer> customers;
        customers = customerService.fetchAllCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> fetchCustomerById(@PathVariable("id") Long id) {
        Customer customer;
        customer = customerService.fetchCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        boolean result = customerService.deleteCustomer(id);
        if(result)
            return ResponseEntity.ok("Customer with id " + id + " deleted Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
        boolean result = customerService.updateCustomer(id,customer);
        if(result)
            return ResponseEntity.ok("Customer Updated Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
