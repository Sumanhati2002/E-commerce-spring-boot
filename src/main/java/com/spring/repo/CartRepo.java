package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.CartItem;

public interface CartRepo extends JpaRepository<CartItem, Integer>{

}
