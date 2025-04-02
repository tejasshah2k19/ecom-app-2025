package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.grownited.entity.CityEntity;
import com.grownited.entity.StateEntity;
import com.grownited.repository.CityRepository;
import com.grownited.repository.StateRepository;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CityController {
	
	@Autowired
	StateRepository repoState;
	
	@Autowired
	CityRepository repoCity;
    
	@GetMapping("newCity")
	public String newCity(Model model) {
		// select * from state;
				List<StateEntity> allState = repoState.findAll();// all state
				
				model.addAttribute("allState",allState);
		         return "NewCity";
	}
	
	@PostMapping("savecity")
	public String saveCity(CityEntity entitycity) {
		System.out.println(entitycity.getCityName());
		repoCity.save(entitycity);
		return "redirect:/ListCity";
	}
	
	//listcity
	
		@GetMapping("ListCity")
		public String listcity(Model model) {
			//List<CityEntity> cityList = repoCity.findAll();
			
			//how to send data from controller to jsp 
			//Model 
			//model.addAttribute("cityList", cityList);
							//dataName , dataValue 
			//List<CityDto> allCity = repoCity.getAll();
			List<Object[]> listCity = repoCity.getAll();
			model.addAttribute("allCity", listCity);
			
			return "ListCity";
		}
		
		@GetMapping("viewcity")
		public String viewCity(Integer cityId, Model model) {
			// ?
			//System.out.println("id ===> " + cityId);
			//Optional<CityEntity> op = repoCity.findById(cityId);
			//if (op.isEmpty()) {
				// not found
			//} else {
				// data found
				//CityEntity city = op.get();
				// send data to jsp ->
				//model.addAttribute("city", city);
			List<Object[]> op = repoCity.getByCityId(cityId);
			model.addAttribute("city", op);
			return "ViewCity";
		}
		
		@GetMapping("deletecity")
		public String deleteCity(Integer cityId) {
			repoCity.deleteById(cityId);
			return "redirect:/ListCity";
		}
		
		@GetMapping("editcity")
		public String editCity(Integer cityId,Model model) {
			Optional<CityEntity> op = repoCity.findById(cityId);
			if (!op.isPresent()) {
				return "redirect:/ListCity";
			} else {
				model.addAttribute("city",op.get());
				return "EditCity";

			}
		}

		@PostMapping("updatecity")
		public String updateCity(CityEntity cityEntity) {//pcode vhreg type vid 
			
			System.out.println(cityEntity.getCityId());//id? db? 

			Optional<CityEntity> op = repoCity.findById(cityEntity.getCityId());
			
			if(op.isPresent())
			{
				CityEntity dbCity = op.get(); //pcode vhreg type id userId 
				dbCity.setCityName(cityEntity.getCityName());//code 
				repoCity.save(dbCity);
			}
			return "redirect:/ListCity";
		}
		
}
