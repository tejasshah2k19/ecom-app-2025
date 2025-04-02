package com.grownited.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.CityEntity;
import com.grownited.repository.CategoryRepository;


@Controller
public class CategoryController {

	@Autowired
	CategoryRepository repoCategory;
	
	@GetMapping("category")
	public String category() {
		return "Category";
	}
	
	@PostMapping("savecategory")
	public String saveCategory(CategoryEntity entitycategory) {
		System.out.println(entitycategory.getCategoryName());
		repoCategory.save(entitycategory);
		return "redirect:/listcategory";
	}	
	
	//listcategory
			@GetMapping("listcategory")
			public String listcategory(Model model) {
				List<CategoryEntity> categoryList = repoCategory.findAll();
				
				//how to send data from controller to jsp 
				//Model 
				model.addAttribute("categoryList", categoryList);
								//dataName , dataValue 
				
				return "ListCategory";
			}
			
			@GetMapping("viewcategory")
			public String viewCategory(Integer categoryId, Model model) {
				// ?
				System.out.println("id ===> " + categoryId);
				Optional<CategoryEntity> op = repoCategory.findById(categoryId);
				if (!op.isPresent()) {
					// not found
				} else {
					// data found
					CategoryEntity category = op.get();
					// send data to jsp ->
					model.addAttribute("category", category);

				}

				return "ViewCategory";
			}
			
			@GetMapping("deletecategory")
			public String deleteCategory(Integer categoryId) {
				repoCategory.deleteById(categoryId);
				return "redirect:/listcategory";
			}	
			@GetMapping("editcategory")
			public String editCategory(Integer categoryId,Model model) {
				Optional<CategoryEntity> op = repoCategory.findById(categoryId);
				if (!op.isPresent()) {
					return "redirect:/listcategory";
				} else {
					model.addAttribute("category",op.get());
					return "EditCategory";

				}
			}  

			@PostMapping("updatecategory")
			public String updateCategory(CategoryEntity categoryEntity) {
				
				System.out.println(categoryEntity.getCategoryId());

				Optional<CategoryEntity> op = repoCategory.findById(categoryEntity.getCategoryId());
				
				if(op.isPresent())
				{
					CategoryEntity dbCategory = op.get(); //pcode vhreg type id userId 
					dbCategory.setCategoryName(categoryEntity.getCategoryName());//code 
					repoCategory.save(dbCategory);
				}
				return "redirect:/listcategory";
			}			
	}

