package com.grownited.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.grownited.entity.OrderDetailEntity;
import com.grownited.entity.OrdersEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.OrderDetailRepository;
import com.grownited.repository.OrdersRepository;
import com.grownited.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderDetailController {

	@Autowired
	OrderDetailRepository repoorderdetail;
	
	@Autowired
	ProductRepository repositoryProduct;
	
	@Autowired
	OrdersRepository repoorders;
	
	@GetMapping("neworderdetail")
	public String newOrderDetail(Model model) {
       
       List<ProductEntity> allProduct = repositoryProduct.findAll();// all state
		model.addAttribute("allProduct",allProduct);
		List<OrdersEntity> allOrders = repoorders.findAll();// all state
		model.addAttribute("allOrders",allOrders);
		return "NewOrderDetail";
	}
	
	@PostMapping("saveorderdetail")
	public String saveOrderDetail(OrderDetailEntity entityorderdetail) {
		System.out.println(entityorderdetail.getQuantity());
		System.out.println(entityorderdetail.getPrice());
		System.out.println(entityorderdetail.getProductId());
		System.out.println(entityorderdetail.getStatus());
		repoorderdetail.save(entityorderdetail);
		return "redirect:/listorderdetail";
	}
	//listorderdetail
		@GetMapping("listorderdetail")
		public String listorderdetail(Model model) { 
			List<Object[]> listorderdetail = repoorderdetail.getAll();
			model.addAttribute("allorderdetail", listorderdetail);
			return "ListOrderDetail";
		}
	
		@GetMapping("vieworderdetail")
		public String viewOrderDetail(Integer orderDetailId, Model model) {
//			System.out.println("id ===> " + orderDetailId);
//			Optional<OrderDetailEntity> op = repoorderdetail.findById(orderDetailId);
//			if (op.isEmpty()) {
//			not found
//			} else {
//			data found
//			OrderDetailEntity orderdetail = op.get();
//			send data to jsp ->
//			model.addAttribute("orderdetail", orderdetail);
//			}
			List<Object[]> op = repoorderdetail.getByOrderDetailId(orderDetailId);
			model.addAttribute("orderdetail", op);
			return "ViewOrderDetail";
		}
		
		@GetMapping("deleteorderdetail")
		public String deleteOrderDetail(Integer orderDetailId) {
			repoorderdetail.deleteById(orderDetailId);
			return "redirect:/listorderdetail";
		}	
		@GetMapping("editorderdetail")
		public String editOrderDetail(Integer orderDetailId,Model model) {
			Optional<OrderDetailEntity> op = repoorderdetail.findById(orderDetailId);
			if (!op.isPresent()) {
				return "redirect:/listorderdetail";
			} else {
				model.addAttribute("orderdetail",op.get());
				return "EditOrderDetail";

			}
		}
		@PostMapping("updateorderdetail")
		public String updateOrderDetail(OrderDetailEntity orderDetailEntity) {//pcode vhreg type vid 
			
			System.out.println(orderDetailEntity.getOrderDetailId());//id? db? 

			Optional<OrderDetailEntity> op = repoorderdetail.findById(orderDetailEntity.getOrderDetailId());
			
			if(op.isPresent())
			{
				OrderDetailEntity dbOrderDetail = op.get(); //pcode vhreg type id userId 
				dbOrderDetail.setQuantity(orderDetailEntity.getQuantity());//code
				dbOrderDetail.setPrice(orderDetailEntity.getPrice());
				dbOrderDetail.setStatus(orderDetailEntity.getStatus());
				repoorderdetail.save(dbOrderDetail);
			}
			return "redirect:/listorderdetail";
		}

}
