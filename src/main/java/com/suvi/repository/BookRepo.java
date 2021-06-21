package com.suvi.repository;


//import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suvi.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

	  List<Book> findByBookNameContaining(String book_name);
	  
	  Book findByBookCode(String bookCode);
	  
	  List<Book> findByLanguage(String language);
	  
	  //List<Book> findByCategory(String category);
	  
	  //List<Book> findByPurchaseDate(Date from, Date to);
	  
	  //List<Book> findByPurchaseShop(String shop);

	  List<Book> findByCategoryContaining(String category);
}
