package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ProductEntity;
import com.grownited.repository.ProductRepository;

@Controller
public class UserController {

	@Autowired
	ProductRepository productRepository;

	@GetMapping("home")
	public String home(Model model) {

		List<ProductEntity> allProduct = productRepository.findAll();
		model.addAttribute("allProduct",allProduct); 
		
		
		return "Home";
	}

	@GetMapping("products")
	public String products() {
		return "Products";
	}

	@GetMapping("productdetail")
	public String productdetail() {
		return "ProductDetail";
	}

	@GetMapping("shopingcart")
	public String shopingcart() {
		return "ShopingCart";
	}

	@GetMapping("blog")
	public String blog() {
		return "Blog";
	}

	@GetMapping("contact")
	public String contact() {
		return "Contact";
	}

	@GetMapping("about")
	public String about() {
		return "About";
	}

	@GetMapping("blogdetail")
	public String blogdetail() {
		return "BlogDetail";
	}
}