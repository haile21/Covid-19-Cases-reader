package com.addistutor.covid19CaseRecord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.addistutor.covid19CaseRecord.model.CaseLocation;
import com.addistutor.covid19CaseRecord.services.Covid19DataService;

 
@Controller
public class IndexController {
	
	 @Autowired
	 Covid19DataService dataservice;
	
	@GetMapping("/covid19")
	public String index(Model model) {
		//model.addAttribute("Name", "Haile");
		List<CaseLocation> allstates= dataservice.getAllcases();
		int totalcases=allstates.stream().mapToInt(state->state.getRecent_total_Case()).sum();
		int newCases=allstates.stream().mapToInt(state->state.getDiff()).sum();
				
		model.addAttribute("AllStates",allstates );
		model.addAttribute("TotalCases",totalcases );
		model.addAttribute("newCases",newCases );


		return "index";
	}

}
