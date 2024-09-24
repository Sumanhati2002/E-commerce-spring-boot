package com.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.CartItem;
import com.spring.repo.CartRepo;
import com.spring.service.CartService;

@Service
public class CartItemImpl implements CartService{

	@Autowired
	private CartRepo cartRepo;

	@Override
	public CartItem createCartItem(CartItem cartItem) {
		
		return cartRepo.save(cartItem);
	}

}
