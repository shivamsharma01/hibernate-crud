package com.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BookPK implements Serializable {
	private int bookId;
	private int libraryId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
}
