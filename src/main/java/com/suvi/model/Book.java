package com.suvi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@Column(name="Book_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	
	@Column(name="BOOK_CODE")
	private String bookCode;
	
	@Column(name="BOOk_NAME")
	private String bookName;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="LANGUAGE")
	private String language;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBook_code() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookCode=" + bookCode + ", bookName=" + bookName + ", category="
				+ category + ", description=" + description + ", language=" + language + "]";
	}

}
