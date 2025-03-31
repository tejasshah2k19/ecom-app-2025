package com.grownited.controller.admin;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.grownited.entity.StateEntity;
import com.grownited.repository.StateRepository;


@Controller
public class StateController {
     
	@Autowired
	StateRepository repoState;
	
	@GetMapping("newstate")
	public String newState() {
		return "NewState";
	}
	
	@PostMapping("savestate")
	public String saveState(StateEntity state) {
		System.out.println(state.getStateName());
		repoState.save(state);
		return "redirect:/liststate";
    }
	
	//liststate
	
		@GetMapping("liststate")
		public String liststate(Model model) {
			List<StateEntity> stateList = repoState.findAll();
			
			//how to send data from controller to jsp 
			//Model 
			model.addAttribute("stateList", stateList);
							//dataName , dataValue 
			
			return "ListState";
		}
		
		@GetMapping("viewstate")
		public String viewState(Integer stateId, Model model) {
			// ?
			System.out.println("id ===> " + stateId);
			Optional<StateEntity> op = repoState.findById(stateId);
			if (op.isEmpty()) {
				// not found
			} else {
				// data found
				StateEntity state = op.get();
				// send data to jsp ->
				model.addAttribute("state", state);

			}

			return "ViewState";
		}
		
		@GetMapping("deletestate")
		public String deleteState(Integer stateId) {
			repoState.deleteById(stateId);
			return "redirect:/liststate";
		}	
		
		@GetMapping("editstate")
		public String editState(Integer stateId,Model model) {
			Optional<StateEntity> op = repoState.findById(stateId);
			if (op.isEmpty()) {
				return "redirect:/liststate";
			} else {
				model.addAttribute("state",op.get());
				return "EditState";

			}
		}
		//save -> entity -> no id present -> insert 
		//save -> entity -> id present -> not present in db -> insert 
		//save -> entity -> id present -> present in db -> update  

		@PostMapping("updatestate")
		public String updateState(StateEntity stateEntity) {//pcode vhreg type vid 
			
			System.out.println(stateEntity.getStateId());//id? db? 

			Optional<StateEntity> op = repoState.findById(stateEntity.getStateId());
			
			if(op.isPresent())
			{
				StateEntity dbState = op.get(); //pcode vhreg type id userId 
				dbState.setStateName(stateEntity.getStateName());//code 
				repoState.save(dbState);
			}
			return "redirect:/liststate";
		}
	
}
