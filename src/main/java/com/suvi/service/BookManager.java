package com.suvi.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suvi.model.Book;
import com.suvi.repository.BookRepo;

@Service
@Transactional
public class BookManager {
	@Autowired
	private BookRepo bookRepo;
	
	public Book saveBook(Book book) {
		bookRepo.save(book);
		return book;
	}
	
	public List<Book> saveBooks(List<Book> books) {
		bookRepo.saveAll(books);
		return books;
	}
	public Optional<Book> getBook(long book_id) {
		return bookRepo.findById(book_id);
	}
	public void deleteBook(long book_id) {
		bookRepo.deleteById(book_id);
	}
	
	public List<Book> listAllBooks(){
		return bookRepo.findAll();
	}
	
	
	public List<Book> listBooksByName(String name) {
		return bookRepo.findByBookNameContaining(name);
	}

	public Book listBookByCode(String bookCode) {
		return bookRepo.findByBookCode(bookCode);
	}

	public List<Book> listBooksByLang(String lang_id) {
		return bookRepo.findByLanguage(lang_id);
	}

	public List<Book> listBooksByCategory(String category) {
		return bookRepo.findByCategoryContaining(category);
	}

	/*
	 * public List<Book> listBooksByPurchaseDate(Date from, Date to) { return
	 * bookRepo.findByPurchase_Date(from, to); }
	 */

	public List<Book> listBooksByPurchaseShop(String shop) {
		return null;//bookRepo.findByPurchaseShop(shop);
	}
	 
}
