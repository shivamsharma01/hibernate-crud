package com.demo.entity;

import java.util.Calendar;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BOOK_TABLE")
public class BookEntity {
	@EmbeddedId
	private BookPK bookid;
	@Temporal(TemporalType.DATE)
	private Calendar issueDate;

	public BookPK getBookid() {
		return bookid;
	}

	public void setBookid(BookPK bookid) {
		this.bookid = bookid;
	}

	public Calendar getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Calendar issueDate) {
		this.issueDate = issueDate;
	}
}
