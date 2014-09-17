package com.acordier.register.dao;



import java.io.Serializable;

import com.acordier.register.model.User;

public interface UserDao extends Serializable {
	/**
	 * Save user to persistence layer
	 * @param user
	 */
	public void saveUser(User user);
	/**
	 * Update user in persistence layer
	 * @param user
	 */
	public void updateUser(User user);
	/**
	 * Delete user from persistence layer
	 * @param user
	 */
	public void deleteUser(User user);
	/**
	 * Find user in persistence layer given a unique named attribute
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 */
	public User findByUniqueAttribute(String attributeName, Object attributeValue);
}
