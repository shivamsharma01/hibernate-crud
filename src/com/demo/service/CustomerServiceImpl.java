package com.demo.service;

import com.demo.dao.CustomerDao;
import com.demo.dao.CustomerDaoImpl;
import com.demo.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao = new CustomerDaoImpl();
	@Override
	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(Integer id) {
		return dao.getCustomer(id);
	}

	@Override
	public void removeCustomer(Integer id) {
		dao.removeCustomer(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		dao.updateCustomer(customer);
	}

}
