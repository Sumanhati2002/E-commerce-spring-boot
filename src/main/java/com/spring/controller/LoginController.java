package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.Customer;
import com.spring.entity.Login;
import com.spring.service.CustomerService;

@Controller
public class LoginController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/processlogin")
	public String processlogin(@ModelAttribute Login login) {
		for(Customer val : customerService.getAllCustomers()) {
			if(val.getUserEmail().equals(login.getUserEmail()) && val.getUserPassword().equals(login.getUserPassword()))
				return "index";
		}
		return "signup";
	}
}
