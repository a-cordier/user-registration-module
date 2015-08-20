package com.acordier.register.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		UIInput passwordField = (UIInput) context.getViewRoot().findComponent("register-form:password");
	    if (passwordField == null)
	        throw new IllegalArgumentException(String.format("Unable to find component."));
	    String password = (String) passwordField.getValue();
	    String confirmPassword = (String) value;
	    if (!confirmPassword.equals(password)) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Passwords do not match!", "Passwords do not match!");
	        throw new ValidatorException(message);
	    }
		
	}

}
