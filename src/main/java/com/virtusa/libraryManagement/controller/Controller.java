package com.virtusa.libraryManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.libraryManagement.dao.BookorderingRequest;
import com.virtusa.libraryManagement.entites.Author;
import com.virtusa.libraryManagement.entites.Book;
import com.virtusa.libraryManagement.entites.Customer;
import com.virtusa.libraryManagement.entites.Payment;
//import com.virtusa.libraryManagement.exception.BookNotFoundException;
import com.virtusa.libraryManagement.exception.FileNotFoundException;
//import com.virtusa.libraryManagement.exception.UserNotFoundException;
import com.virtusa.libraryManagement.service.AdminService;
import com.virtusa.libraryManagement.service.BookService;
import com.virtusa.libraryManagement.service.CustomerService;
import com.virtusa.libraryManagement.service.PaymentService;

@RestController
@RequestMapping
public class Controller {

	@Autowired
	private BookService bookService;
	@Autowired
	private AdminService adminSerive;
	@Autowired
	private PaymentService paymentService;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/books")
	public String addBooks(@RequestBody Book book) {
		bookService.addBook(book);
		return "Book added";
	}

	/*
	 * @PostMapping("/author") public String addAuthors(@RequestBody Author author)
	 * { adminSerive.addAuthor(author); return "admin added  author sucessfully"; }
	 * 
	 * @PostMapping("/customer") public String addCustomers(@RequestBody Customer
	 * customer) { adminSerive.addCustomer(customer); return
	 * "admin added customer sucessfully"; }
	 * 
	 * 
	 * 
	 * @DeleteMapping("/author/{authorId}") public String removeAuthor(@PathVariable
	 * Long authorId) { adminSerive.removeAuthor(authorId); return
	 * "Admin removed the Author successfully"; }
	 */

	@PostMapping("/customerRegistration")
	public String customerRegistration(@RequestBody Customer customer) {
		customerService.customerRegistraion(customer);
		return "Customer Registered successfully";
	}

	@GetMapping("/viewAllBooks")
	public List<Book> viewAllBook() {
		return customerService.viewAllBooks();
	}

	@GetMapping("/customerViewHistory")
	public List<Payment> customerViewPaymentHistory() {
		return customerService.customerViewHistorty();
	}

	@GetMapping("/viewAllBooks/{id}")
	public ResponseEntity<Book> searchByBookId( @PathVariable Long id) throws FileNotFoundException {
		
		return ResponseEntity.ok(customerService.searchByBookId(id));
		// return ResponseEntity.ok(service.getUser(id));
	}
//	

	@DeleteMapping("/cancelBook/{id}")
	public String cancelBook(@PathVariable(value = "id") Long id)  {
		customerService.cancelBook(id);
		return "customer canceled book";
	}

	@GetMapping(value = "/customer/{title}")
	public List<Book> searchBooksByTitle(@PathVariable(value = "title") String title, String author) {

		List<Book> books;
		return books = customerService.searchBooks(title, author);

	}

	@GetMapping(value = "/customer/{author}")
	public List<Book> searchBooksByAuthor(@PathVariable(value = "author") String title, String author) {

		List<Book> books;

		return books = customerService.searchBooks(title, author);
	}

//
////	
	@PostMapping("/orderBooks")
	public String orderBook(@RequestBody BookorderingRequest request) {
		paymentService.orderBook(request);
		return "Payment successfully";
	}

}
