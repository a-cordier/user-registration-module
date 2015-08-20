package com.acordier.register.jsf;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;


/* use CDI @SessionScoped, NOT javax.faces.bean.* */
import javax.enterprise.context.SessionScoped; 
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.apache.commons.codec.binary.Base64;
import org.primefaces.model.UploadedFile;

import com.acordier.register.bo.UserBo;
import com.acordier.register.model.User;

@Named
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private UploadedFile avatar;

	@Inject
	private UserBo userBo;

	private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UploadedFile getAvatar() {
		return avatar;
	}

	public void setAvatar(UploadedFile avatar) {
		this.avatar = avatar;
	}
	/**
	 * Save user from form input
	 */
	public String saveUser() {
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setUsername(username);
		try { /* Hash password */
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(password.getBytes("UTF-8"));
			user.setPassword(Base64.encodeBase64String(digest.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO VIEW DIALOG
			logger.severe(e.getLocalizedMessage());
		} catch (UnsupportedEncodingException e) {
			// TODO VIEW DIALOG
			logger.severe(e.getLocalizedMessage());
		}
		if(avatar!=null){
			logger.info("AVATAR FOUND");
			byte[] avatarBuffer = new byte[safeCastToInt(avatar.getSize())];
			try {
				avatar.getInputstream().read(avatarBuffer);
				user.setAvatar(avatarBuffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/* Persist user */
		userBo.saveUser(user); 
		return "success";
	}

	/**
	 * Get correct value or throw exception
	 * 
	 * @param l
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static int safeCastToInt(long l) throws IllegalArgumentException {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l
					+ " cannot be cast to int without changing its value.");
		}
		return (int) l;
	}
}
