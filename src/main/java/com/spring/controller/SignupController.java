package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.Customer;
import com.spring.service.CustomerService;

import jakarta.validation.Valid;

@Controller
public class SignupController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// This handler helps to handle signup request
	@PostMapping("/processform")
	public String createUser(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {

		try {
			if (bindingResult.hasErrors()) {
				return "signup";
			}
			customer.setRole("ROLE_USER");
			String encodedPassword = passwordEncoder.encode(customer.getUserPassword());
			customer.setUserPassword(encodedPassword);
			
			this.customerService.createCustomer(customer);
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "signup";
		}

	}

	// Get customer by Id
	@GetMapping("{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	// Get all customer
	@GetMapping
	public ResponseEntity<List<Customer>> getAllUsers() {
		List<Customer> costomers = customerService.getAllCustomers();
		return new ResponseEntity<>(costomers, HttpStatus.OK);
	}

	// Delete Customer
	@DeleteMapping("{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer customerId) {
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
}
