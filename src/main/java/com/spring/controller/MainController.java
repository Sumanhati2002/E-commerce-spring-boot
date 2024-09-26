package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.entity.Customer;
import com.spring.entity.Image;
import com.spring.repo.ImageRepo;
import com.spring.service.ImageService;

@Controller
public class MainController {

	@Autowired
	private ImageRepo imageRepo;


	
	@Autowired
	private ImageService imageService;

	// this is index view handler
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	// this is shop view handler
	// show 8 image per page
	@GetMapping("/shop")
	public String shop(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "8") Integer size,
			Model model) {

		Pageable pageable = PageRequest.of(page, size);
		Page<Image> images = imageRepo.findAll(pageable);

		model.addAttribute("images", images);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", images.getTotalPages());

		return "shop";
	}

	
	
	// this is about view handler
	@GetMapping("/about")
	public String about() {
		return "normal/about";
	}

	
	// this is services view handler
	@GetMapping("/services")
	public String services() {
		return "services";
	}

	// this is blog view handler
	@GetMapping("/blog")
	public String blog() {
		return "blog";
	}

	// this is contact view handler
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	// this is account view handler
	@GetMapping("/account")
	public String account() {

		return "account";
	}

	// this is signup view handler
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("customer", new Customer());
		return "signup";
	}

	// this is login view handler
	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	// this is admin view handler
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	// this will help to show product details
	@GetMapping("/pdp/{id}")
	public String pdp(@PathVariable("id") Integer id, Model model) {

		Image image = imageService.findImageById(id);

		model.addAttribute("image", image);
		return "pdp";

	}
	
	//this is check out handler
	@GetMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	
}
