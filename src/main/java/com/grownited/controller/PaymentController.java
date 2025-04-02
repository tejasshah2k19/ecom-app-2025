package com.grownited.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.grownited.entity.CartEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.service.PaymentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	CartRepository cartRepository;

	@GetMapping("checkout")
	public String checkout(Model model, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<Object[]> carts = cartRepository.getAllCartItemByUserId(user.getUserId());

		Integer amount = 0;
		for (Object c[] : carts) {
			amount = amount + Integer.parseInt(c[1].toString());
		}

		System.out.println("amount => " + amount);
		model.addAttribute("amount", amount);
		return "Checkout";// credit card expDate

	}

	@PostMapping("pay")
	public String pay(String ccNum, String expDate, HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");

		// get all items from cart
		List<Object[]> carts = cartRepository.getAllCartItemByUserId(user.getUserId());

		Integer amount = 0;
		for (Object c[] : carts) {
			amount = amount + Integer.parseInt(c[1].toString());
		}

		System.out.println("amount => " + amount);
		Integer paymentId = paymentService.chargeCreditCard("22UmU47bLLM", "8Hg2g7W677KasR25", amount * 1.0, ccNum,
				expDate, user.getEmail(), user.getUserId());
		if (paymentId == -1) {
			return "redirect:/checkout";
		}
//		cartRepo.deleteAll(userId); 

		return "redirect:/home";
	}

}
