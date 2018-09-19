package com.paypal.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.paypal.book.exception.BookNotFoundException;
import com.paypal.book.model.Book;

@Component
public class BookService {
	
	private static List<Book> bookList = new ArrayList<>();
	
	static {
		Book book = new Book(1, "Learn Java in 2 days", "Lavanya", 2000, "Neha Publishers", 30.00);
		bookList.add(book);
		book = new Book(2, "Learn Spring in 1 day", "Ana", 2008, "Donald Publishers", 20.00);
		bookList.add(book);
		book = new Book(3, "Learn SpringBoot in 3 days", "Lavanya", 2017, "FDC Publishers", 50.00);
		bookList.add(book);
		book = new Book(4, "Learn Hibernate in 2 days", "Ana", 2010, "Neha Publishers", 15.00);
		bookList.add(book);
	}
		
	public List<Book> getAllBooks(){
		return bookList;
	}
	
	public Book getBookById(int id){
		for(Book book : bookList) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}
	
	public Book addBook(Book book){
		bookList.add(book);
		return book;
	}
	
	public void deleteBook(int id) throws BookNotFoundException {
		boolean bookFound = false;
		for(Book book : bookList) {
			if(book.getId() == id) {
				bookFound = true;
				bookList.remove(book);
				break;
			}
		}
		if(!bookFound) {
			throw new BookNotFoundException("Book not found. Id = " + id);
		}
	}
}
