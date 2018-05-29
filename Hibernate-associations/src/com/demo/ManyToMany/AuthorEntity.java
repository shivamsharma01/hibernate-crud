package com.demo.ManyToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR_ASSOCIATION_TABLE")
public class AuthorEntity {
	@Id
	@Column(name = "ID")
	private int authorId;
	private String authorName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "AUTHORBOOK_TABLE", joinColumns = @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID") , inverseJoinColumns = @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID") )
	private List<BookEntity> books;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}
}
