package com.virtusa.libraryManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.libraryManagement.entites.Author;
import com.virtusa.libraryManagement.entites.Book;
import com.virtusa.libraryManagement.repository.AuthorRepository;
import com.virtusa.libraryManagement.repository.BookRepository;

@Service
public class AuthorService {
	@Autowired
	public AuthorRepository authorRepository;
	@Autowired
	public BookRepository bookRepository;

	public void authorRegistrion(Author author) {
		authorRepository.save(author);
	}

	public void authorAddsBook(Book book) {
		bookRepository.save(book);
	}

	public List<Book> viewAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;

	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	public void authoreditsBook(Long id, Book book) {
		bookRepository.save(book);
	}
}
