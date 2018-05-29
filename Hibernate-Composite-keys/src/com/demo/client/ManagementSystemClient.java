package com.demo.client;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.entity.BookEntity;
import com.demo.entity.BookPK;
import com.demo.entity.ClassroomEntity;
import com.demo.entity.ClassroomPK;
import com.demo.util.HibernateUtil;

public class ManagementSystemClient {

	public static void main(String[] args) {
		idClassPk();
		embeddedPk();
	}

	private static void idClassPk() {
		Session session = HibernateUtil.getSession();
		ClassroomEntity clsEntity = new ClassroomEntity();
		clsEntity.setClassroomId(101);
		clsEntity.setClassroomId(101);
		clsEntity.setBatchId(1);
		clsEntity.setCapacity(60);
		Transaction tx = session.beginTransaction();
		ClassroomPK pk = (ClassroomPK) session.save(clsEntity);
		tx.commit();
		session.close();
	}
	
	private static void embeddedPk() {
		Session session = HibernateUtil.getSession();
		BookEntity bookEntity = new BookEntity();
		BookPK pk = new BookPK();
		pk.setBookId(1001);
		pk.setLibraryId(201);
		bookEntity.setIssueDate(Calendar.getInstance());
		bookEntity.setBookid(pk);
		Transaction tx = session.beginTransaction();
		pk = (BookPK)session.save(bookEntity);
		tx.commit();
		session.close();
	}

}
