package com.emanuellangit.dissertation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.emanuellangit.dissertation.model.SequenceInformation;

public class SequenceInformationValidator implements Validator {
	
	private static final String EMAIL_ADDRESSS_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return SequenceInformation.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		SequenceInformation sequenceInformation = (SequenceInformation) obj;
		
		if (!sequenceInformation.getEmailAddress().matches(EMAIL_ADDRESSS_PATTERN)) {
			errors.rejectValue("emailAddress", "valid.emailAddress");
		}
		
	}

}