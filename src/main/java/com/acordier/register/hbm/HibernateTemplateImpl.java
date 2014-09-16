package com.acordier.register.hbm;

import javax.enterprise.inject.Default;
import javax.inject.Singleton;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

@Default
@Singleton
public class HibernateTemplateImpl implements HibernateTemplate {

	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory;

	private SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();
			ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			ServiceRegistry serviceRegistry = serviceRegistryBuilder
					.buildServiceRegistry();
			return configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			synchronized (HibernateTemplateImpl.class) {
				sessionFactory = buildSessionFactory();
			}
		}
		return sessionFactory;
	}

	public void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
