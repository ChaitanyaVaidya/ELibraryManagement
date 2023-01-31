package com.virtusa.libraryManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.libraryManagement.entites.Book;
import com.virtusa.libraryManagement.repository.AuthorRepository;
import com.virtusa.libraryManagement.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	public BookRepository bookRepository;

	public void addBook(Book book) {
		bookRepository.save(book);
	}

}
