package com.acordier.register;

import javax.inject.Inject;

import junit.framework.TestCase;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.acordier.register.bo.UserBo;
import com.acordier.register.bo.UserBoImpl;
import com.acordier.register.dao.UserDao;
import com.acordier.register.dao.UserDaoMockImpl;
import com.acordier.register.model.User;

@RunWith(CdiRunner.class)
@AdditionalClasses({ UserDaoMockImpl.class, UserBoImpl.class })
public class TestUserBo extends TestCase {

	@Inject
	private UserDao userDao;

	@Inject
	private UserBo userBo;


	@Test /* should invoke daoTestImpl save method */
	public void testSaveUser() {
		User user = new User();
		userBo.saveUser(user); 
		assertNotNull(userDao.findByUniqueAttribute("username", "mockito"));
		user.setUsername("mockito-2");
		userBo.updateUser(user);
		assertNull(userDao.findByUniqueAttribute("username", "mockito"));
		assertNotNull(userDao.findByUniqueAttribute("username", "mockito-2"));
		userBo.deleteUser(user);
		assertNull(userDao.findByUniqueAttribute("username", "mockito-2"));
	}
}
