package com.acordier.register.dao;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.acordier.register.hbm.HibernateTemplate;
import com.acordier.register.model.User;

@Default
public class UserDaoImpl implements UserDao {

	private static final long serialVersionUID = 1L;

	@Inject
	private HibernateTemplate hibernateTemplate;


	@Override
	public void saveUser(User user) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void updateUser(User user) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteUser(User user) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public User findUserByUserName(String username) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(User.class);
			criteria.add(Restrictions.eq("username", username));
			List<?> resultSet = criteria.list();
			return resultSet.isEmpty() ? null : (User) resultSet.get(0);
		} catch (Exception e) {
			tx.rollback();
			return null;
		} finally {
			session.close();
		}
		
		
	}

	@Override
	public boolean exists(String username) {
		return findUserByUserName(username)!=null;
	}
}
