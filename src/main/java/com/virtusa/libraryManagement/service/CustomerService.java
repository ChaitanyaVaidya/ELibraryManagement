package com.virtusa.libraryManagement.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.libraryManagement.entites.Book;
import com.virtusa.libraryManagement.entites.Customer;
import com.virtusa.libraryManagement.entites.Payment;
//import com.virtusa.libraryManagement.exception.BookNotFoundException;
import com.virtusa.libraryManagement.exception.FileNotFoundException;
import com.virtusa.libraryManagement.repository.BookRepository;
import com.virtusa.libraryManagement.repository.CustomerRepository;
import com.virtusa.libraryManagement.repository.PaymentRepository;

@Service
public class CustomerService {
	@Autowired
	public CustomerRepository customerRepository;
	@Autowired
	public BookRepository bookRepository;
	@Autowired
	public PaymentRepository paymentRepository;

	public void customerRegistraion(Customer customer) {
		customerRepository.save(customer);

	}

	public List<Book> viewAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;

	}

	public Book searchByBookId(Long id) throws FileNotFoundException {
		Book book= bookRepository.findById(id).get();
        if(book!=null){
            return book;
        }else{
            throw new FileNotFoundException("book not found with id : "+id);
        }

	//	return bookRepository.findById(id).get();

	}

	public void cancelBook(Long id) {
		bookRepository.deleteById(id);
	}

	public List<Book> searchBooks(String title, String author) {

		List<Book> searchedBooks = new ArrayList<Book>();

		if (title != null && author == null) {
			searchedBooks = getByTitle(title);
		} else if (title == null && author != null) {
			searchedBooks = getByAuthor(author);
		} else if (title != null && author != null) {
			searchedBooks = getByTitleAndAuthor(title, author);
		}

		return searchedBooks;
	}

	public List<Book> getByAuthor(String author) {
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepository.findAll()) {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}

	public List<Book> getByTitleAndAuthor(String title, String author) {
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepository.findAll()) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())
					&& book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}

	public List<Book> getByTitle(String title) {
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepository.findAll()) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}

	public List<Payment> customerViewHistorty() {
		List<Payment> payment = new ArrayList<>();
		paymentRepository.findAll().forEach(payment::add);
		return payment;

	}

}
