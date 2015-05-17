package com.emanuellangit.dissertation.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class SequenceInformation {
	private String nucleotideSequence;
	private MultipartFile file;
	private String blastDb;
	
	@NotEmpty(message = "Please enter your email address")
	@Email(message = "Please enter a valid email address")
	private String emailAddress;
	
	
	@NotNull(message = "Please enter an expect value")
	@Min(0)
	@Max(10)
	private Double eValue;
	
	public String getNucleotideSequence() {
		return nucleotideSequence;
	}
	public void setNucleotideSequence(String nucleotideSequence) {
		this.nucleotideSequence = nucleotideSequence;
	}
	public MultipartFile getFilename() {
		return file;
	}
	public void setFilename(MultipartFile file) {
		this.file = file;
	}
	public String getBlastDb() {
		return blastDb;
	}
	public void setBlastDb(String blastDb) {
		this.blastDb = blastDb;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Double geteValue() {
		return eValue;
	}
	public void seteValue(Double eValue) {
		this.eValue = eValue;
	}

}
