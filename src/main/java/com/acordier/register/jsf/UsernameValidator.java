package com.acordier.register.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.acordier.register.bo.UserBo;

@Named
public class UsernameValidator implements Validator {
	
	@Inject
	private UserBo userBo;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object username)
			throws ValidatorException {
		if(username==null){
			return;
		}
		if(userBo.exists(username.toString())){
			throw new ValidatorException(new FacesMessage(
	                FacesMessage.SEVERITY_ERROR, "Username " + username + " is already in use.", null));
		}

	}

}
