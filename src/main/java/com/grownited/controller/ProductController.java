package com.grownited.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.SubCategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductController {

	@Autowired
	ProductRepository repositoryProduct;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	SubCategoryRepository repoSubCategory;
	
	@Autowired
	Cloudinary cloudinary;
	
	@GetMapping("product")
	public String product(Model model) {
        List<CategoryEntity> allCategory = repoCategory.findAll();// all state
		
		model.addAttribute("allCategory",allCategory);
        List<SubCategoryEntity> allSubCategory = repoSubCategory.findAll();// all state
		
		model.addAttribute("allSubCategory",allSubCategory);
		return "Product";
	}
	
	@PostMapping("saveproduct")
	public String saveProduct(ProductEntity entityproduct,@RequestParam("productImage1") MultipartFile productImage1, @RequestParam("productImage2") MultipartFile productImage2, @RequestParam("productImage3") MultipartFile productImage3) {
		System.out.println(productImage1.getOriginalFilename());// file name
		System.out.println(productImage2.getOriginalFilename());
		System.out.println(productImage3.getOriginalFilename());
		try {
			Map result = cloudinary.uploader().upload(productImage1.getBytes(), ObjectUtils.emptyMap());
			System.out.println(result);
			System.out.println(result.get("url"));
			entityproduct.setProductImageURL1(result.get("url").toString());
			
			Map result1 = cloudinary.uploader().upload(productImage2.getBytes(), ObjectUtils.emptyMap());
			System.out.println(result1);
			System.out.println(result1.get("url"));
			entityproduct.setProductImageURL2(result1.get("url").toString());
			
			Map result2 = cloudinary.uploader().upload(productImage3.getBytes(), ObjectUtils.emptyMap());
			System.out.println(result2);
			System.out.println(result2.get("url"));
			entityproduct.setProductImageURL3(result2.get("url").toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(entityproduct.getProductName());
		System.out.println(entityproduct.getOfferPercentage());
		System.out.println(entityproduct.getProductDetail());
		System.out.println(entityproduct.getQuantity());
		entityproduct.setCreatedAt(new Date());
		repositoryProduct.save(entityproduct);
		return "redirect:/listproduct";
	}
	
	//listproduct
		@GetMapping("listproduct")
		public String listproduct(Model model) {
			//List<ProductEntity> productList = repositoryProduct.findAll();
			
			//how to send data from controller to jsp 
			//Model 
			//model.addAttribute("productList", productList);
							//dataName , dataValue 
			List<Object[]> listProduct = repositoryProduct.getAll();
			model.addAttribute("productList", listProduct);
			return "ListProduct";
		}

		@GetMapping("viewproduct")
		public String viewProduct(Integer productId, Model model) {
//			System.out.println("id ===> " + productId);
//			Optional<ProductEntity> op = repositoryProduct.findById(productId);
//			if (op.isEmpty()) {
//			not found
//			} else {
//			data found
//			ProductEntity product = op.get();
//			send data to jsp ->
//			model.addAttribute("product", product);
//          }
			List<Object[]> op = repositoryProduct.getByProductId(productId);
			model.addAttribute("product", op);
			return "ViewProduct";
		}
		
		@GetMapping("deleteproduct")
		public String deleteProduct(Integer productId) {
			repositoryProduct.deleteById(productId);
			return "redirect:/listproduct";
		}	
		@GetMapping("editproduct")
		public String editProduct(Integer productId,Model model) {
			Optional<ProductEntity> op = repositoryProduct.findById(productId);
			if (op.isEmpty()) {
				return "redirect:/listproduct";
			} else {
				model.addAttribute("product",op.get());
				return "EditProduct";
			}
		}
		@PostMapping("updateproduct")
		public String updateProduct(ProductEntity productEntity, @RequestParam("productImage1") MultipartFile productImage1, @RequestParam("productImage2") MultipartFile productImage2, @RequestParam("productImage3") MultipartFile productImage3) {//pcode vhreg type vid 
			
			System.out.println(productEntity.getProductId());//id? db? 
			System.out.println(productImage1.getOriginalFilename());
			System.out.println(productImage2.getOriginalFilename());
			System.out.println(productImage3.getOriginalFilename());
			
			Optional<ProductEntity> op = repositoryProduct.findById(productEntity.getProductId());
			
			try {
				Map result = cloudinary.uploader().upload(productImage1.getBytes(), ObjectUtils.emptyMap());
				System.out.println(result);
				System.out.println(result.get("url"));
				productEntity.setProductImageURL1(result.get("url").toString());
				
				Map result1 = cloudinary.uploader().upload(productImage2.getBytes(), ObjectUtils.emptyMap());
				System.out.println(result1);
				System.out.println(result1.get("url"));
				productEntity.setProductImageURL2(result1.get("url").toString());
				
				Map result2 = cloudinary.uploader().upload(productImage3.getBytes(), ObjectUtils.emptyMap());
				System.out.println(result2);
				System.out.println(result2.get("url"));
				productEntity.setProductImageURL3(result2.get("url").toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(productEntity.getProductImageURL1());
			if(op.isPresent())
			{
				ProductEntity dbProduct = op.get(); //pcode vhreg type id userId 
				dbProduct.setProductName(productEntity.getProductName());//code 
				dbProduct.setBasePrice(productEntity.getBasePrice());
				dbProduct.setOfferPrice(productEntity.getOfferPrice());
				dbProduct.setOfferPercentage(productEntity.getOfferPercentage());
				dbProduct.setProductDetail(productEntity.getProductDetail());
				dbProduct.setProductImageURL1(productEntity.getProductImageURL1());
				dbProduct.setProductImageURL2(productEntity.getProductImageURL2());
				dbProduct.setProductImageURL3(productEntity.getProductImageURL3());
				dbProduct.setQuantity(productEntity.getQuantity());
				repositoryProduct.save(dbProduct);
			}
			return "redirect:/listproduct";
		}
		
		@GetMapping("/userviewproduct")
		public String userViewProduct(Integer productId,Model model) {
			Optional<ProductEntity> op = repositoryProduct.findById(productId);
			
			if(op.isPresent()) {
				model.addAttribute("product",op.get());
				return "UserViewProduct";
			}else {
				return "redirect:/home";
			}
			
		}
		
		
		
}
