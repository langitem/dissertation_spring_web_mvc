package com.emanuellangit.dissertation;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emanuellangit.dissertation.model.SequenceInformation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("sequenceInformation", new SequenceInformation());

		
		return "home"; // filename of view (.jsp file) to be displayed
	}
	
	
}
