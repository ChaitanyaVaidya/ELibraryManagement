package com.virtusa.libraryManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.libraryManagement.entites.Author;
import com.virtusa.libraryManagement.entites.Book;
import com.virtusa.libraryManagement.service.AuthorService;

@RestController
@RequestMapping
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@PostMapping("/authorResigtration")
	public String authorRegistration(@RequestBody Author author) {
		authorService.authorRegistrion(author);
		return "Author Registered Successfully";
	}

	@PostMapping("/authorAddsBook")
	public String authorAddsBooks(@Valid @RequestBody Book book) {
		authorService.authorAddsBook(book);
		return "author adds book";
	}

	@GetMapping("/authorviewAllBooks")
	public List<Book> viewAllBook() {
		return authorService.viewAllBooks();
	}

	@DeleteMapping("/deleteBook/{id}")
	public String authorDeleteBook(@PathVariable(value = "id") Long id) {
		authorService.deleteBook(id);
		return "Author canceled book";
	}

	@PutMapping("/editBook/{id}")
	public String authorEditBooks(@PathVariable(value = "id") Long id, @RequestBody Book book) {
		authorService.authoreditsBook(id, book);
		return "author edited book";
	}
}
