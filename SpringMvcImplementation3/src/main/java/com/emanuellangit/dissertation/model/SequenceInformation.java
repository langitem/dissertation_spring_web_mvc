package com.emanuellangit.dissertation.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class SequenceInformation {
	private String nucleotideSequence;
	private String filename;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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