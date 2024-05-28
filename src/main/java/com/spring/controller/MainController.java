package com.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.entity.Image;
import com.spring.repo.ImageRepo;


@Controller
public class MainController {
	
	@Autowired
	private ImageRepo imageRepo;
	
	@GetMapping("/show")
	public String show() {

		return "index";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/shop")
	public String shop(Model model){
		List<Image> images = (List<Image>) imageRepo.findAll();
		model.addAttribute("images", images);
		return "shop";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/services")
	public String services() {
		return "services";
	}

	@GetMapping("/blog")
	public String blog() {
		return "blog";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/account")
	public String account() {

		return "account";
	}

	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	@GetMapping("/pdp")
	public String pdp() {
		return "pdp";
	}
}
