package com.paypal.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.book.exception.BookNotFoundException;
import com.paypal.book.model.Book;
import com.paypal.book.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping(value = "/books")
	public List<Book> getAllBooks() {
    	return bookService.getAllBooks();
	}
	
	@GetMapping(value = "/{id}")
	public Book getBookById(@PathVariable("id") int id) {
    	return bookService.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") int id) throws BookNotFoundException {
		bookService.deleteBook(id);
	}
	
	@PutMapping("/books")
	public void updateBook(@PathVariable("id") int id) {
		//bookService.deleteBook(id);
	}
}
