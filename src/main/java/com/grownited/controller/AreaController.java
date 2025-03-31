package com.grownited.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.AreaEntity;
import com.grownited.entity.CityEntity;
import com.grownited.repository.AreaRepository;
import com.grownited.repository.CityRepository;

@Controller
public class AreaController {
	
	@Autowired
	AreaRepository repoArea;
	
	@Autowired
	CityRepository repoCity;
    
	@GetMapping("newArea")
	public String newArea(Model model) {
        List<CityEntity> allCity = repoCity.findAll();// all state
		
		model.addAttribute("allCity",allCity);
		return "NewArea";
	}
	
	@PostMapping("savearea")
	public String saveArea(AreaEntity entityarea) {
		System.out.println(entityarea.getAreaName());
		repoArea.save(entityarea);
		return "redirect:/listarea";
	}
	
	//listarea
		@GetMapping("listarea")
		public String listarea(Model model) {
			//List<AreaEntity> areaList = repoArea.findAll();// select * from area; //500 -> arearEntity
			
			//how to send data from controller to jsp 
			//Model 
			//model.addAttribute("areaList", areaList);
							//dataName , dataValue 
			List<Object[]> listArea = repoArea.getAll();
			model.addAttribute("allArea", listArea);
			
			return "ListArea";
		}
		
		@GetMapping("viewarea")
		public String viewArea(Integer areaId, Model model) {
//			// ?
//			System.out.println("id ===> " + areaId);
//			Optional<AreaEntity> op = repoArea.findById(areaId);
//			if (op.isEmpty()) {
//				// not found
//			} else {
//				// data found
//				AreaEntity area = op.get();
//				// send data to jsp ->
//				model.addAttribute("area", area);
//			}
			List<Object[]> op = repoArea.getByAreaId(areaId);
			model.addAttribute("area", op);
			return "ViewArea";
		}
		
		@GetMapping("deletearea")
		public String deleteArea(Integer areaId) {
			repoArea.deleteById(areaId);
			return "redirect:/listarea";
		}	
	
		@GetMapping("editarea")
		public String editArea(Integer areaId,Model model) {
			Optional<AreaEntity> op = repoArea.findById(areaId);
			if (op.isEmpty()) {
				return "redirect:/listarea";
			} else {
				model.addAttribute("area",op.get());
				return "EditArea";
			}
		}

		@PostMapping("updatearea")
		public String updateArea(AreaEntity areaEntity) {//pcode vhreg type vid 
			
			System.out.println(areaEntity.getAreaId());//id? db? 
			Optional<AreaEntity> op = repoArea.findById(areaEntity.getAreaId());
			
			if(op.isPresent())
			{
				AreaEntity dbArea = op.get(); //pcode vhreg type id userId 
				dbArea.setAreaName(areaEntity.getAreaName());//code 
				repoArea.save(dbArea);
			}
			return "redirect:/listarea";
		}
}
