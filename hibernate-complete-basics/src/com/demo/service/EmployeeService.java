package com.demo.service;

import java.util.List;

import com.demo.entity.Employee;

public interface EmployeeService {
	public void add(Employee employee);
	public Long getCount();
	public List<Employee> getAll();
	public List<Object> getEmployeeAndAsset(int empId);
	public void updatePassword(int empId, String password);
	public void deleteEmployeeAndAsset(int empId);
}
