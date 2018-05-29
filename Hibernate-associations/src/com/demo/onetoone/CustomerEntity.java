package com.demo.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_ASSOCIATION_TABLE")
public class CustomerEntity {
	@Id
	private int customerId;
	private String customerName;
	private int age;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lockerId", unique = true)
	private LockerEntity locker;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LockerEntity getLocker() {
		return locker;
	}

	public void setLocker(LockerEntity locker) {
		this.locker = locker;
	}
}
