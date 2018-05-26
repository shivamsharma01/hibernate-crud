package com.demo.dao;

import org.hibernate.Session;

import com.demo.entity.Customer;
import com.demo.utils.HibernateUtils;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void saveCustomer(Customer customer) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Customer getCustomer(Integer id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Customer cust = session.get(Customer.class, id);
		session.getTransaction().commit();
		session.close();
		return cust;
	}

	@Override
	public void removeCustomer(Integer id) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		Customer cust = session.get(Customer.class, id);
		if (cust != null) {
			session.delete(cust);
		}
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		session.saveOrUpdate(customer);
		session.getTransaction().commit();
		session.close();
	}

}
