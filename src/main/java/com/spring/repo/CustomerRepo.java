package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	@Query("select c from Customer c where c.userEmail = :userEmail")
	public Customer getCustomerByCustomerName(@Param("userEmail") String userEmail);
}
