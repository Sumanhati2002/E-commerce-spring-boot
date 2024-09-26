package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.entity.Customer;
import com.spring.repo.CustomerRepo;

public class CustomerDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// fetch data from database
		Customer customer=customerRepo.getCustomerByCustomerName(username);
		
		if(customer==null) {
			throw new UsernameNotFoundException("could not found customer");
		}
		CustomCustomerDetails customCustomerDetails=new CustomCustomerDetails(customer);
		
		return customCustomerDetails;
	}

}
