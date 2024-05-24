package com.spring.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.entity.Customer;
import com.spring.repo.CustomerRepo;
import com.spring.service.CustomerService;

@Service
public class CustomerImpl implements CustomerService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Customer createCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Optional<Customer> customer=customerRepo.findById(customerId);
		return customer.get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return (List<Customer>) customerRepo.findAll();
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		
		customerRepo.deleteById(customerId);
	}

}
