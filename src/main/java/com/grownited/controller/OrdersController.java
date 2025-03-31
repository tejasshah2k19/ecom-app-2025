package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.grownited.entity.OrderDetailEntity;
import com.grownited.entity.OrdersEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.OrdersRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {

	@Autowired
	OrdersRepository repoorders;
	
	@GetMapping("neworders")
	public String newOrders() {
		return "NewOrders";
	}
	
	@PostMapping("saveorders")
	public String saveOrders(OrdersEntity entityorders, HttpSession session) {
		System.out.println(entityorders.getTotalAmount());
		entityorders.setCreatedAt(new Date());
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
		entityorders.setUserId(userId);
		repoorders.save(entityorders);
		return "redirect:/listorders";
	}
	
	//listorders
	@GetMapping("listorders")
	public String listorders(Model model) {
		//List<OrdersEntity> ordersList = repoorders.findAll();
		
		//how to send data from controller to jsp 
		//Model 
		//model.addAttribute("ordersList", ordersList);
						//dataName , dataValue 
		List<Object[]> listOrders = repoorders.getAll();
		model.addAttribute("ordersList", listOrders);
		return "ListOrders";
	}

	@GetMapping("vieworders")
	public String viewOrders(Integer orderId, Model model) {
//		System.out.println("id ===> " + orderId);
//		Optional<OrdersEntity> op = repoorders.findById(orderId);
//		if (op.isEmpty()) {
//		not found
//		} else {
//		data found
//		OrdersEntity orders = op.get();
//		send data to jsp ->
//		model.addAttribute("orders", orders);
//		}
		List<Object[]> op = repoorders.getByOrdersId(orderId);
		model.addAttribute("orders", op);
		return "ViewOrders";
	}
	
	@GetMapping("deleteorders")
	public String deleteOrders(Integer orderId) {
		repoorders.deleteById(orderId);
		return "redirect:/listorders";
	}	
	@GetMapping("editorders")
	public String editOrder(Integer orderId,Model model) {
		Optional<OrdersEntity> op = repoorders.findById(orderId);
		if (op.isEmpty()) {
			return "redirect:/listorders";
		} else {
			model.addAttribute("orders",op.get());
			return "EditOrders";

		}
	}
	@PostMapping("updateorder")
	public String updateOrder(OrdersEntity orderEntity) {//pcode vhreg type vid 
		
		System.out.println(orderEntity.getOrderId());//id? db? 

		Optional<OrdersEntity> op = repoorders.findById(orderEntity.getOrderId());
		
		if(op.isPresent())
		{
			OrdersEntity dbOrder = op.get(); //pcode vhreg type id userId 
			dbOrder.setTotalAmount(orderEntity.getTotalAmount());//code
			dbOrder.setStatus(orderEntity.getStatus());
			repoorders.save(dbOrder);
		}
		return "redirect:/listorders";
	}

}
