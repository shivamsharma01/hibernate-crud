package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.demo.entity.Assets;
import com.demo.entity.Employee;
import com.demo.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public void add(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Long getCount() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("Select Count(*) from Employee");
		session.beginTransaction();
		List<Long> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list.get(0);
	}

	@Override
	public List<Employee> getAll() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Employee order by empName asc");
		session.beginTransaction();
		List<Employee> list = query.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Object> getEmployeeAndAsset(int empId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = session.get(Employee.class, empId);
		List<Object> empAndAsset = new ArrayList<>();
		if (emp == null) {
			return empAndAsset;
		}
		Integer assetId = emp.getAssetId();
		Assets asset = null;
		if (assetId != null) {
			asset = session.get(Assets.class, assetId);
		}
		empAndAsset.add(emp);
		empAndAsset.add(asset);
		session.getTransaction().commit();
		session.close();
		return empAndAsset;
	}

	@Override
	public void updatePassword(int empId, String password) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = session.get(Employee.class, empId);
		if (emp != null) {
			emp.setPassword(password);
		}
		session.persist(emp);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void deleteEmployeeAndAsset(int empId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = session.get(Employee.class, empId);
		session.delete(emp);
		Integer assetId = emp.getAssetId();
		Assets asset = null;
		if (assetId != null) {
			asset = session.get(Assets.class, assetId);
		}
		session.delete(asset);
		session.getTransaction().commit();
		session.close();
	}

}
