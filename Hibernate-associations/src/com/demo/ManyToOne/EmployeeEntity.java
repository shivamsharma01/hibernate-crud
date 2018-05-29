package com.demo.ManyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_ASSOCIATION_TABLE")
public class EmployeeEntity {
	@Id
	@Column(name = "ID")
	private int empId;
	private String empName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departmentId")
	private DepartmentEntity dep;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public DepartmentEntity getDep() {
		return dep;
	}

	public void setDep(DepartmentEntity dep) {
		this.dep = dep;
	}
}
