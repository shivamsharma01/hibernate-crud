package com.demo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Customer;

public class HibernateUtils {
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration();
			config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/development");
			config.setProperty("hibernate.connection.username", "root");
			config.setProperty("hibernate.connection.password", "Inm+jeto1");
			// config.setProperty("hibernate.hbm2ddl.auto", "create");
			config.addAnnotatedClass(Customer.class);
			config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
			sessionFactory = config.configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Error in creating SessionFactory object." + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}

}
