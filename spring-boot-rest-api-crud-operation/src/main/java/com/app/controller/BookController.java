package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Book;
import com.app.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBook() {

		List<Book> list = bookService.getAllBook();
		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getAllBookById(@PathVariable("id") int id) {
		Book book = bookService.getBookById(id);
		if (book == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));

	}

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = null;
		b = this.bookService.addBook(book);
		System.out.println(book);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/books /{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable ("id") int id) {
		
		this.bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		
	}
}
