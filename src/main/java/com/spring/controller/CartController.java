package com.spring.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.CartItem;
import com.spring.entity.Customer;
import com.spring.repo.CustomerRepo;
import com.spring.service.CartService;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private CustomerRepo customerRepo;
	
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println("username" + userName);

		Customer customer = customerRepo.getCustomerByCustomerName(userName);
		System.out.println(customer);

		model.addAttribute(customer);
	}
	
	@PostMapping("/cart")
	public String showCart(Model model, @ModelAttribute CartItem cartItem, Principal principal) {

		CartItem cartitems = cartService.createCartItem(cartItem);
		model.addAttribute("cartitems", cartitems);
		return "cart";
	}
	
}
