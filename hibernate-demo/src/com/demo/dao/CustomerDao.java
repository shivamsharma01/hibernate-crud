package com.demo.dao;

import com.demo.entity.Customer;

public interface CustomerDao {
	public void saveCustomer(Customer customer);
	public Customer getCustomer(Integer id);
	public void removeCustomer(Integer id);
	public void updateCustomer(Customer customer);
}
