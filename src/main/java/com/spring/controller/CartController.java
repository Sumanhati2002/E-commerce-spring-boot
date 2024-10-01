package com.spring.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.entity.CartItem;
import com.spring.entity.Customer;
import com.spring.repo.CartRepo;
import com.spring.repo.CustomerRepo;

@Controller
public class CartController {

	
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	// handler for save item in cart
	@PostMapping("/cart")
	public String showCart(Model model, @ModelAttribute CartItem cartItem, Principal principal) {

		try {
			String name = principal.getName();
			Customer customer = this.customerRepo.getCustomerByCustomerName(name);
			
			customer.getCartitems().add(cartItem);
			cartItem.setCustomer(customer);
			
			this.customerRepo.save(customer);
			System.out.println(cartItem);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "index";
	}

	//it will show all cart items
	@GetMapping("/show-cartItem")
	public String showContacts(Model model, Principal principal) {

		String userName = principal.getName();
		Customer customer = this.customerRepo.getCustomerByCustomerName(userName);


		List<CartItem> cartitems = this.cartRepo.findCartItemByCustomer(customer.getCustomerId());

		int totalAmount = cartitems.stream().mapToInt(CartItem::getTotalAmount).sum();
		
		model.addAttribute("cartitems", cartitems);
		model.addAttribute("totalAmount", totalAmount);
		return "cart";
	}
	
	//delete cart item
	@GetMapping("/delete/{cartId}")
	public String deleteCartItem(@PathVariable("cartId") Integer cartId) {

		CartItem item= this.cartRepo.findById(cartId).get();
		this.cartRepo.delete(item);

		return "redirect:/show-cartItem";
	}
	
	//update the cart items
	@PostMapping("/updateCart")
	public String updateCart(@ModelAttribute CartItem cartItem, Principal principal) {
		
		try {
			Customer customer= this.customerRepo.getCustomerByCustomerName(principal.getName());
			cartItem.setCustomer(customer);
			this.cartRepo.save(cartItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/show-cartItem";
	}
	
	//this is check out handler
		@GetMapping("/checkout")
		public String checkout(Model model, Principal principal) {
			
			String userName = principal.getName();
			Customer customer = this.customerRepo.getCustomerByCustomerName(userName);


			List<CartItem> cartitems = this.cartRepo.findCartItemByCustomer(customer.getCustomerId());

			int totalAmount = cartitems.stream().mapToInt(CartItem::getTotalAmount).sum();
			
			model.addAttribute("cartitems", cartitems);
			model.addAttribute("totalAmount", totalAmount);
			
			return "checkout";
		}
}
