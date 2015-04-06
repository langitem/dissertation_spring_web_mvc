package com.emanuellangit.dissertation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emanuellangit.dissertation.model.SequenceInformation;

@Controller
public class SequenceInputFormController {
	
	@RequestMapping(value="sequenceInputForm", method=RequestMethod.GET)
	public String sequenceInputForm(Model model) {
		model.addAttribute("sequenceInformation", new SequenceInformation());
		return "sequenceInputFormPage";	
	}
	
	@RequestMapping(value="sequenceInputForm", method=RequestMethod.POST)
	public String sequenceSubmit(@ModelAttribute SequenceInformation sequenceInformation, Model model) {
		model.addAttribute("sequenceInformation", sequenceInformation);

		return "sequenceSubmittedPage";
	}

}
