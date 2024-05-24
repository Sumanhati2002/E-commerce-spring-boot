package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);
	Customer getCustomerById(Integer customerId);
    List<Customer> getAllCustomers();
    void deleteCustomer(Integer customerId);
}
