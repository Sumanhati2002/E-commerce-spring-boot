package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.CartItem;
import com.spring.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/cart")
	public String showCart(Model model, @ModelAttribute CartItem cartItem) {

		System.out.println(cartItem);
		CartItem cartitems = cartService.createCartItem(cartItem);
		model.addAttribute("cartitems", cartitems);
		return "cart";
	}
}
