package com.acordier.register.hbm;

import java.io.Serializable;

import org.hibernate.SessionFactory;

public interface HibernateTemplate extends Serializable {
	public SessionFactory getSessionFactory();
	public void shutdown();
}
