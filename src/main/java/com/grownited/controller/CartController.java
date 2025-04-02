package com.grownited.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.CartEntity;
import com.grownited.entity.CityEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CartRepository;
import com.grownited.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class CartController {

	@Autowired
	CartRepository repositoryCart;
	
	@Autowired
	ProductRepository repositoryProduct;
	
	
	@GetMapping("addtocart")
	public String addToCart(Integer productId,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
		
		CartEntity cart = new CartEntity(); 
		cart.setProductId(productId);
		cart.setUserId(userId);
		cart.setQuantity(1);
		
		repositoryCart.save(cart);
		return "redirect:/shopingcart";
	}
	
	
	
	@GetMapping("cart")
	public String cart(Model model) {
        List<ProductEntity> allProduct = repositoryProduct.findAll();// all state
		
		model.addAttribute("allProduct",allProduct);

		return "Cart";
	}
	
	@PostMapping("savecart")
	public String saveCart(CartEntity entitycart, HttpSession session) {
		System.out.println(entitycart.getQuantity());
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
		entitycart.setUserId(userId);
		repositoryCart.save(entitycart);
		return "redirect:/listcart";
	}
	
	//listcart
	@GetMapping("listcart")
	public String listcart(Model model) {
		//List<CartEntity> cartList = repositoryCart.findAll();
		
		//how to send data from controller to jsp 
		//Model 
		//model.addAttribute("cartList", cartList);
						//dataName , dataValue 
		List<Object[]> listCart = repositoryCart.getAll();
		model.addAttribute("cartList", listCart);
		return "ListCart";
	}
	
	@GetMapping("viewcart")
	public String viewCart(Integer cartId, Model model) {
//		System.out.println("id ===> " + cartId);
//		Optional<CartEntity> op = repositoryCart.findById(cartId);
//		if (op.isEmpty()) {
//		// not found
//		} else {
//		// data found
//		CartEntity cart = op.get();
//		// send data to jsp ->
//		model.addAttribute("cart", cart);
//		}
		List<Object[]> op = repositoryCart.getByCityId(cartId);
		model.addAttribute("cart", op);
		return "ViewCart";
	}
	
	@GetMapping("deletecart")
	public String deleteCart(Integer cartId) {
		repositoryCart.deleteById(cartId);
		return "redirect:/listcart";
	}	
	
	@GetMapping("editcart")
	public String editCart(Integer cartId,Model model) {
		Optional<CartEntity> op = repositoryCart.findById(cartId);
		if (!op.isPresent()) {
			return "redirect:/listcart";
		} else {
			model.addAttribute("cart",op.get());
			return "EditCart";

		}
	}

	@PostMapping("updatecart")
	public String updateCart(CartEntity cartEntity) {//pcode vhreg type vid 
		
		System.out.println(cartEntity.getCartId());//id? db? 

		Optional<CartEntity> op = repositoryCart.findById(cartEntity.getCartId());
		
		if(op.isPresent())
		{
			CartEntity dbCart = op.get(); //pcode vhreg type id userId 
			dbCart.setQuantity(cartEntity.getQuantity());//code 
			repositoryCart.save(dbCart);
		}
		return "redirect:/listcart";
	}
	

	@GetMapping("shopingcart")
	public String shopingcart(HttpSession session,Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
		List<Object[]>	products  = repositoryCart.getAllCartItemByUserId(userId);
		model.addAttribute("products",products);
		return "ShopingCart";
	}
	
	@GetMapping("removecart")
	public String removeCart(Integer cartId) {
		repositoryCart.deleteById(cartId);
		return "redirect:/shopingcart";
	}
	
	
}
