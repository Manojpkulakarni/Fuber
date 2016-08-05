/**
 * 
 */
package com.egov.fuber.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author Manoj Kulkarni
 *
 */
public class CustomerValidator implements Validator {

	/**
	 * 
	 */
	public CustomerValidator() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.error");
		ValidationUtils.rejectIfEmpty(errors, "sex", "sex.error");
		ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.error");
		ValidationUtils.rejectIfEmpty(errors, "longitude", "longitude.error");
		ValidationUtils.rejectIfEmpty(errors, "latitude", "latitude.error");
	}

}
