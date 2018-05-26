package com.demo.service;

import java.util.List;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao = new EmployeeDaoImpl();
	
	@Override
	public void add(Employee employee) {
		dao.add(employee);
	}

	@Override
	public Long getCount() {
		return dao.getCount();
	}

	@Override
	public List<Employee> getAll() {
		return dao.getAll();
	}

	@Override
	public List<Object> getEmployeeAndAsset(int empId) {
		return dao.getEmployeeAndAsset(empId);
	}

	@Override
	public void updatePassword(int empId, String password) {
		dao.updatePassword(empId, password);
	}

	@Override
	public void deleteEmployeeAndAsset(int empId) {
		dao.deleteEmployeeAndAsset(empId);
	}

}
