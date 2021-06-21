package com.suvi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suvi.model.Book;
import com.suvi.service.BookManager;

@Controller
public class BookController {

	@Autowired
	private BookManager bookManager;

	@GetMapping("/Books")
	public String booksHome(Model model) {
		return ("Books");
	}

	@RequestMapping("/addBooks")
	public String addBooksForm(Model model) {
		return ("BooksAdd");
	}

	@PostMapping("/saveBook") 
	public String saveBooks(Book book) {
		System.out.println("===========inside controller=====SaveBooks=====");
		bookManager.saveBook(book); 
		//return new ResponseEntity<Book>(bookAdded,
		//HttpStatus.CREATED); 
		return ("BooksAdd"); 
	}
	  

	@GetMapping("/listBooks")
	public String listBooks(Model model) {
		List<Book> booksList = bookManager.listAllBooks();
		model.addAttribute("booksList", booksList);
		return "BooksList";
	}

	@GetMapping("/editBook") 
	public void editBook(Model model) {
		System.out.println("===========inside controller=====Edit=====");
		//return("../static/addbooks.html"); 
	}

	@PostMapping("/updateBook")
	public String updateBook(Model model) {
		System.out.println("===========inside controller====Save======");
		return ("BooksList");
	}

	@RequestMapping("/deleteBook")
	public void deleteBook(Model model) {
		System.out.println("===========inside controller=======Delete===");
		// return("../static/addbooks.html");

	}

}
