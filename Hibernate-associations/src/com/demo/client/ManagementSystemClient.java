package com.demo.client;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.ManyToMany.AuthorEntity;
import com.demo.ManyToMany.BookEntity;
import com.demo.ManyToOne.DepartmentEntity;
import com.demo.ManyToOne.EmployeeEntity;
import com.demo.onetoone.CustomerEntity;
import com.demo.onetoone.LockerEntity;
import com.demo.util.HibernateUtil;

public class ManagementSystemClient {

	public static void main(String[] args) {
		oneToOne();
		ManyToOne();
		ManyToMany();
	}

	private static void oneToOne() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		CustomerEntity csEntity = new CustomerEntity();
		LockerEntity lockerEntity = new LockerEntity();
		csEntity.setCustomerId(101);
		csEntity.setCustomerName("Shivam");
		csEntity.setAge(25);
		lockerEntity.setLastAccessed(Calendar.getInstance());
		lockerEntity.setLockerId(555);
		csEntity.setLocker(lockerEntity);
		session.save(csEntity);
		tx.commit();
		session.close();
	}

	private static void ManyToOne() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		EmployeeEntity empEntity1 = new EmployeeEntity();
		empEntity1.setEmpId(1001);
		empEntity1.setEmpName("Shivam");
		EmployeeEntity empEntity2 = new EmployeeEntity();
		empEntity2.setEmpId(1002);
		empEntity2.setEmpName("Shubham");
		DepartmentEntity dep = new DepartmentEntity();
		dep.setDepartmentId(101);
		dep.setDepartmentName("Physics");
		empEntity1.setDep(dep);
		empEntity2.setDep(dep);
		session.save(empEntity1);
		session.save(empEntity2);
		tx.commit();
		session.close();
	}

	private static void ManyToMany() {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		AuthorEntity athEntity = new AuthorEntity();
		BookEntity bookEntity1 = new BookEntity();
		bookEntity1.setBookId(101);
		bookEntity1.setBookTitle("Silence of the lambs");
		BookEntity bookEntity2 = new BookEntity();
		bookEntity2.setBookId(102);
		bookEntity2.setBookTitle("The Monk who sold his Ferreri");
		List<BookEntity> books = new ArrayList<>();
		books.add(bookEntity1);
		books.add(bookEntity2);
		athEntity.setBooks(books);
		athEntity.setAuthorId(1001);
		athEntity.setAuthorName("Shivam");
		session.save(athEntity);
		tx.commit();
		session.close();
	}
}
