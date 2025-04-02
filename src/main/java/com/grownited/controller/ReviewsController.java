package com.grownited.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.grownited.entity.CityEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.ReviewsEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.ReviewsRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class ReviewsController {

	@Autowired
	ReviewsRepository reporeviews;
	@Autowired
	ProductRepository repositoryProduct;
	
	@GetMapping("newreviews")
	public String newReviews(Model model) {
        List<ProductEntity> allProduct = repositoryProduct.findAll();
		
		model.addAttribute("allProduct",allProduct);
		return "Reviews";
	}
	
	@PostMapping("savereviews")
	public String saveReviews(ReviewsEntity entityreviews, HttpSession session) {
		System.out.println(entityreviews.getReviewText());
		System.out.println(entityreviews.getRating());
		entityreviews.setCreatedAt(new Date());
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
		entityreviews.setUserId(userId);
		reporeviews.save(entityreviews);
		return "redirect:/listreviews";
	}
	
	//listreviews
		@GetMapping("listreviews")
		public String listreviews(Model model) {
			//List<ReviewsEntity> reviewsList = reporeviews.findAll();
			
			//how to send data from controller to jsp 
			//Model 
			//model.addAttribute("reviewsList", reviewsList);
							//dataName , dataValue 
			List<Object[]> listReviews = reporeviews.getAll();
			model.addAttribute("reviewsList", listReviews);
			return "ListReviews";
		}
		@GetMapping("viewreviews")
		public String viewReviews(Integer reviewId, Model model) {
//			System.out.println("id ===> " + reviewId);
//			Optional<ReviewsEntity> op = reporeviews.findById(reviewId);
//			if (op.isEmpty()) {
//			//not found
//			} else {
//			//data found
//			ReviewsEntity reviews = op.get();
//			//send data to jsp ->
//			model.addAttribute("reviews", reviews);
//			}
		List<Object[]> op = reporeviews.getByReviewsId(reviewId);
		model.addAttribute("reviews", op);
			return "ViewReviews";
		}
		
		@GetMapping("deletereviews")
		public String deleteReviews(Integer reviewId) {
			reporeviews.deleteById(reviewId);
			return "redirect:/listreviews";
		}	
		@GetMapping("editreviews")
		public String editReviews(Integer reviewId,Model model) {
			Optional<ReviewsEntity> op = reporeviews.findById(reviewId);
			if (!op.isPresent()) {
				return "redirect:/listreviews";
			} else {
				model.addAttribute("reviews",op.get());
				return "EditReviews";

			}
		}

		@PostMapping("updatereviews")
		public String updateReviews(ReviewsEntity reviewsEntity) {//pcode vhreg type vid 
			
			System.out.println(reviewsEntity.getReviewId());//id? db? 

			Optional<ReviewsEntity> op = reporeviews.findById(reviewsEntity.getReviewId());
			
			if(op.isPresent())
			{
				ReviewsEntity dbReviews = op.get(); //pcode vhreg type id userId 
				dbReviews.setReviewText(reviewsEntity.getReviewText());//code 
				dbReviews.setRating(reviewsEntity.getRating());
				reporeviews.save(dbReviews);
			}
			return "redirect:/listreviews";
		}
		
}
