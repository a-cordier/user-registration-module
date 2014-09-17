package com.acordier.register.dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.acordier.register.dao.UserDao;
import com.acordier.register.model.User;

/**
 * Testing mock implementation of UserDao interface
 * 
 * @author acordier
 * @see UserDao
 * 
 */
public class UserDaoMockImpl implements UserDao {

	private static final long serialVersionUID = 1L;

	public static final List<User> users = new ArrayList<User>();

	@Override
	public void saveUser(User user) {
		users.add(user);
	}

	@Override
	public void updateUser(User user) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserId() == user.getUserId()) {
				users.set(i, user);
			}
		}
	}

	@Override
	public void deleteUser(User user) {
		users.remove(user);
	}

	@Override
	public User findByUniqueAttribute(String attributeName,
			Object attributeValue) {
		Method method = null;
		for (Method m : User.class.getMethods()) {
			if (m.getName().equals(
					buildGetterNameFromAttributeName(attributeName))) {
				method = m;
			}
		}
		for (User user : users) {
			try {
				if (((String) method.invoke(user)).equals(attributeValue)) {
					return user;
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				
			}
		}
		return null;
	}

	/* Make input[0] upper case */
	private String capitalize(String input) {
		return input.replaceFirst("^.", input.substring(0, 1).toUpperCase());
	}

	private String buildGetterNameFromAttributeName(String attributeName) {
		return "get" + capitalize(attributeName);
	}

}
