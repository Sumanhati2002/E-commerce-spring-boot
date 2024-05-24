package com.spring.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/show")
	public String show() {

		return "index";
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/shop")
	public String shop() {
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
}
