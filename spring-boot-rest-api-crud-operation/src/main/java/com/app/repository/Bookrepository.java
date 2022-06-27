package com.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.Book;

public interface Bookrepository extends CrudRepository<Book, Integer>{

	public Book findById(int id);
}
