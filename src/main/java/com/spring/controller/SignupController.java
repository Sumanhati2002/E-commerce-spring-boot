package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Controller
public class SignupController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/processform")
	public String createUser(@ModelAttribute Customer customer){
		customerService.createCustomer(customer);
        return "index";
    }
	 @GetMapping("{customerId}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId){
	        Customer customer = customerService.getCustomerById(customerId);
	        return new ResponseEntity<>(customer, HttpStatus.OK);
	    }
	 @GetMapping
	    public ResponseEntity<List<Customer>> getAllUsers(){
	        List<Customer> costomers = customerService.getAllCustomers();
	        return new ResponseEntity<>(costomers, HttpStatus.OK);
	    }
	 @DeleteMapping("{customerId}")
	    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer customerId){
	        customerService.deleteCustomer(customerId);
	        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	    }
}
