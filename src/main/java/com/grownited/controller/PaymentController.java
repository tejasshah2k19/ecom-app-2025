package com.grownited.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class PaymentController {

	@GetMapping("checkout")
	public String checkout(Model model) {
		model.addAttribute("amount",500);
		return "Checkout";
	}

	@PostMapping("pay")
	public String pay(String ccNum,String expDate,String cvv) {
		//TODO: process POST request
		
		
		
		return "redirect:/home" ;
	}
	
	
}
