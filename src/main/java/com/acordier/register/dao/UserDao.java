package com.acordier.register.dao;



import java.io.Serializable;

import com.acordier.register.model.User;

public interface UserDao extends Serializable {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User findUserByUserName(String username);
	public boolean exists(String username);
}
