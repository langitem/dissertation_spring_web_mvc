package com.emanuellangit.dissertation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emanuellangit.dissertation.model.SequenceInformation;

@Controller
@RequestMapping(value="/sequenceInput")
public class SequenceInformationController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String viewSequenceInputFormPage(Model model) {
		//model.addAttribute("sequenceInformation", new SequenceInformation());
		
		model.addAttribute("sequenceInformation", new SequenceInformation());
		return "sequenceInputFormPage";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitSequenceInformation(@ModelAttribute SequenceInformation sequenceInformation, Model model ) {
		
		model.addAttribute("sequenceInformation", sequenceInformation);
		
		return "sequenceSubmittedPage";
	}
	
	/*
	private void initializeModelList(Model model) {
		List<String> blastDbList = new ArrayList<String>();
		blastDbList.add("Human Genome");
		blastDbList.add("Human RefSeq NM");
		blastDbList.add("Human RefSeq NR");
		model.addAttribute("blastDb", blastDbList);
		
	}
	*/

}