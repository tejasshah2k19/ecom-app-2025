package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.WishlistRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	WishlistRepository wishlistRepository;
	
	@GetMapping("home")
	public String home(Model model,HttpSession session) {

		List<ProductEntity> allProduct = productRepository.findAll();
		model.addAttribute("allProduct",allProduct); 
		
		UserEntity user  = (UserEntity)session.getAttribute("user");
		Integer totalWishlist  = wishlistRepository.findByUserId(user.getUserId()).size();
		model.addAttribute("totalWishlist",totalWishlist);
		
		
		
		
		
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