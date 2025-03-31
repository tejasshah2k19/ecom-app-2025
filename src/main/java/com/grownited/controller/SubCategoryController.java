package com.grownited.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.entity.UserAddressEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.SubCategoryRepository;

@Controller
public class SubCategoryController {

	@Autowired
	SubCategoryRepository repoSubCategory;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@GetMapping("subcategory")
	public String subCategory(Model model) {
       List<CategoryEntity> allCategory = repoCategory.findAll();// all state
		
		model.addAttribute("allCategory",allCategory);
		return "SubCategory";
	}
	
	@PostMapping("savesubcategory")
	public String saveSubCategory(SubCategoryEntity entitysubcategory) {
		System.out.println(entitysubcategory.getSubCategoryName());
		repoSubCategory.save(entitysubcategory);
		return "redirect:/listsubcategory";
	}	
 
	//listsubcategory
	@GetMapping("listsubcategory")
	public String listsubcategory(Model model) {
		//List<SubCategoryEntity> subcategoryList = repoSubCategory.findAll();
		
		//how to send data from controller to jsp 
		//Model 
		//model.addAttribute("subcategoryList", subcategoryList);
						//dataName , dataValue 
		List<Object[]> listSubCategory = repoSubCategory.getAll();
		model.addAttribute("subcategoryList", listSubCategory);
		
		return "ListSubCategory";
	}
	
	@GetMapping("viewsubcategory")
	public String viewSubCategory(Integer subCategoryId, Model model) {
//		System.out.println("id ===> " + subCategoryId);
//		Optional<SubCategoryEntity> op = repoSubCategory.findById(subCategoryId);
//		if (op.isEmpty()) {
//		not found
//		} else {
//		data found
//		SubCategoryEntity subcategory = op.get();
//		send data to jsp ->
//		model.addAttribute("subcategory", subcategory);
//		}
		List<Object[]> op = repoSubCategory.getBySubCategoryId(subCategoryId);
		model.addAttribute("subcategory", op);
		return "ViewSubCategory";
	}
	
	@GetMapping("deletesubcategory")
	public String deleteSubCategory(Integer subCategoryId) {
		repoSubCategory.deleteById(subCategoryId);
		return "redirect:/listsubcategory";
	}
	@GetMapping("editsubcategory")
	public String editSubCategory(Integer subCategoryId,Model model) {
		Optional<SubCategoryEntity> op = repoSubCategory.findById(subCategoryId);
		if (op.isEmpty()) {
			return "redirect:/listsubcategory";
		} else {
			model.addAttribute("subcategory",op.get());
			return "EditSubCategory";

		}
	}
	@PostMapping("updatesubcategory")
	public String updateSubCategory(SubCategoryEntity subCategoryEntity) {//pcode vhreg type vid 
		
		System.out.println(subCategoryEntity.getSubCategoryId());//id? db? 

		Optional<SubCategoryEntity> op = repoSubCategory.findById(subCategoryEntity.getSubCategoryId());
		
		if(op.isPresent())
		{
			SubCategoryEntity dbSubCategory = op.get(); //pcode vhreg type id userId 
			dbSubCategory.setSubCategoryName(subCategoryEntity.getSubCategoryName());//code
			
			repoSubCategory.save(dbSubCategory);
		}
		return "redirect:/listsubcategory";
	}
	
}
