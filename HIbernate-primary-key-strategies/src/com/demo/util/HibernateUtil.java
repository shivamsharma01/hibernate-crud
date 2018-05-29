package com.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.AssignedStrategyEntity;
import com.demo.entity.IdentityStrategyEntity;
import com.demo.entity.IncrementStrategyEntity;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/development");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "Inm+jeto1");
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		configuration.setProperty("hibernate.show_sql", "true");
		// configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		configuration.addAnnotatedClass(IncrementStrategyEntity.class);
		configuration.addAnnotatedClass(IdentityStrategyEntity.class);
		configuration.addAnnotatedClass(AssignedStrategyEntity.class);
		sessionFactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

}