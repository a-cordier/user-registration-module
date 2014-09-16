package com.acordier.register.bo;


import javax.inject.Inject;
import javax.inject.Named;

import com.acordier.register.dao.UserDao;
import com.acordier.register.model.User;

@Named
public class UserBoImpl implements UserBo {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
	}

	@Override
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}

	@Override
	public boolean exists(String username) {
		return userDao.exists(username);
	}

}
