package com.emanuellangit.dissertation;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;

import com.emanuellangit.dissertation.model.SequenceInformation;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		
		/* backing bean binded to the model, specified with
		 * modelAttribute= in the view
		 */
		SequenceInformation sequenceInformation = new SequenceInformation();
		model.addAttribute("sequenceInformation", sequenceInformation);
		
		return "home"; // filename of view (.jsp file) to be displayed
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitSequenceInformation(@Valid SequenceInformation sequenceInformation, BindingResult result, ModelMap model, @RequestParam(value = "file", required = false) MultipartFile file ) {
	//public String submitSequenceInformation(@Valid SequenceInformation sequenceInformation, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "home";
		}
		
		//just testing, remove this later:
		String filename = file.getOriginalFilename();
		System.out.println("filename: " + filename);
		
		model.addAttribute("nucleotideSequence", sequenceInformation.getNucleotideSequence());
		model.addAttribute("file", sequenceInformation.getFilename());
		model.addAttribute("blastDb", sequenceInformation.getBlastDb());
		model.addAttribute("eValue", sequenceInformation.geteValue());
		model.addAttribute("emailAddress", sequenceInformation.getEmailAddress());
		
		// just testing, remove this later:
		MultipartFile file2 = sequenceInformation.getFilename();
		String filename2 = file2.toString();
		System.out.println(filename2);
		
		// Save file to server if uploaded:
		
		
		String toAddress = sequenceInformation.getEmailAddress();
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(toAddress);
		email.setSubject("BLAST job submission confirmation");
		email.setText("Your BLAST job request has been received. You will receive the results when the BLAST job has completed.");
		
		mailSender.send(email);

		return "sequenceSubmittedPage";
	}
	
}
