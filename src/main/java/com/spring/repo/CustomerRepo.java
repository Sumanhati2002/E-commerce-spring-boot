package com.spring.repo;

import org.springframework.data.repository.CrudRepository;

import com.spring.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, Integer>{

}
