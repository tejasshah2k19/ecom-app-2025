package com.grownited.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.entity.UserAddressEntity;
import com.grownited.entity.UserEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;
import com.grownited.repository.UserAddressRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserAddressController {

	@Autowired
	UserAddressRepository repoUserAddress;
	
	@Autowired
	StateRepository repoState;
	
	@Autowired
	CityRepository repoCity;
	
	@GetMapping("useraddress")
	public String userAddress(Model model) {
		List<StateEntity> allState = repoState.findAll();// all state
		
		model.addAttribute("allState",allState);
		
        List<CityEntity> allCity = repoCity.findAll();// all state
		
		model.addAttribute("allCity",allCity);
		return "UserAddress";
	}
	
	@PostMapping("saveUserAddress")
	public String saveUserAddress(UserAddressEntity entityuseraddress, HttpSession session) {
		System.out.println(entityuseraddress.getTitle());
	    System.out.println(entityuseraddress.getUnitName());
	    System.out.println(entityuseraddress.getStreet());
	    System.out.println(entityuseraddress.getLandMark());
	    System.out.println(entityuseraddress.getZipCode());
	    UserEntity user = (UserEntity) session.getAttribute("user");
		Integer userId = user.getUserId(); 
		entityuseraddress.setUserId(userId);
	    repoUserAddress.save(entityuseraddress);
		return "redirect:/listuseraddress";
	}
	
	//listuseraddress
		@GetMapping("listuseraddress")
		public String listUserAddress(Model model) {
			//List<UserAddressEntity> useraddressList = repoUserAddress.findAll();
			
			//how to send data from controller to jsp 
			//Model 
			List<Object[]> listUserAddress = repoUserAddress.getAll();
			model.addAttribute("useraddressList", listUserAddress);	
							//dataName , dataValue 
			return "ListUserAddress";
		}
		
		@GetMapping("viewuseraddress")
		public String viewUserAddress(Integer userAddressId, Model model) {
//			
//			System.out.println("id ===> " + userAddressId);
//			Optional<UserAddressEntity> op = repoUserAddress.findById(userAddressId);
//			if (op.isEmpty()) {
//				 not found
//			} else {
//				 data found
//				UserAddressEntity useraddress = op.get();
//				send data to jsp ->
//				model.addAttribute("useraddress", useraddress);
//
//			}
			List<Object[]> op = repoUserAddress.getByUserAddressId(userAddressId);
			model.addAttribute("useraddress", op);

			return "ViewUserAddress";
		}
		
		@GetMapping("deleteuseraddress")
		public String deleteUserAddress(Integer userAddressId) {
			repoUserAddress.deleteById(userAddressId);
			return "redirect:/listuseraddress";
		}	
		@GetMapping("edituseraddress")
		public String editUserAddress(Integer userAddressId,Model model) {
			Optional<UserAddressEntity> op = repoUserAddress.findById(userAddressId);
			if (op.isEmpty()) {
				return "redirect:/listuseraddress";
			} else {
				model.addAttribute("useraddress",op.get());
				return "EditUserAddress";

			}
		}
		//save -> entity -> no id present -> insert 
		//save -> entity -> id present -> not present in db -> insert 
		//save -> entity -> id present -> present in db -> update  

		@PostMapping("updateuseraddress")
		public String updateUserAddress(UserAddressEntity userAddressEntity) {//pcode vhreg type vid 
			
			System.out.println(userAddressEntity.getUserAddressId());//id? db? 

			Optional<UserAddressEntity> op = repoUserAddress.findById(userAddressEntity.getUserAddressId());
			
			if(op.isPresent())
			{
				UserAddressEntity dbUserAddress = op.get(); //pcode vhreg type id userId 
				dbUserAddress.setTitle(userAddressEntity.getTitle());//code
				dbUserAddress.setUnitName(userAddressEntity.getUnitName());
				dbUserAddress.setStreet(userAddressEntity.getStreet());
				dbUserAddress.setLandMark(userAddressEntity.getLandMark());
				dbUserAddress.setAddressDetail(userAddressEntity.getAddressDetail());
				dbUserAddress.setZipCode(userAddressEntity.getZipCode());
				repoUserAddress.save(dbUserAddress);
			}
			return "redirect:/listuseraddress";
		}
		
}
