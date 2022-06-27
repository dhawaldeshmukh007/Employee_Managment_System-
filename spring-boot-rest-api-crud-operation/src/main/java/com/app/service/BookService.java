package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.entity.Book;
import com.app.repository.Bookrepository;

@Component
public class BookService {

	@Autowired
	private Bookrepository bookrepository;

	public List<Book> getAllBook() {
		List<Book> list = (List<Book>) this.bookrepository.findAll();
		
		return list;
	}

	public Book getBookById(int id) {
		Book book = null;
		book = this.bookrepository.findById(id);
		book = this.bookrepository.findById(id);
		return book;
	}

	public Book addBook(Book b) {

		Book result = this.bookrepository.save(b);
		return result;

	}

	public void deleteBook(int id) {
		bookrepository.deleteById(id);
	}
	
	public void updateBook() {

		
		
	}
}
