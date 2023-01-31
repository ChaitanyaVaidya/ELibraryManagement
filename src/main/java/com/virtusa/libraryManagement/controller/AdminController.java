package com.virtusa.libraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.libraryManagement.entites.Author;
import com.virtusa.libraryManagement.entites.Customer;
import com.virtusa.libraryManagement.service.AdminService;

@RestController
@RequestMapping
public class AdminController {
	@Autowired
	private AdminService adminSerive;

	@PostMapping("/author")
	public String addAuthors(@RequestBody Author author) {
		adminSerive.addAuthor(author);
		return "admin added  author sucessfully";
	}

	@PostMapping("/customer")
	public String addCustomers(@RequestBody Customer customer) {
		adminSerive.addCustomer(customer);
		return "admin added customer sucessfully";
	}

	@DeleteMapping("/author/{authorId}")
	public String removeAuthor(@PathVariable Long authorId) {
		adminSerive.removeAuthor(authorId);
		return "Admin removed the Author successfully";
	}

	@DeleteMapping("/customer/{customerId}")
	public String removeCustomer(@PathVariable Long customerId) {
		adminSerive.removeCustomer(customerId);
		return "Admin removed the customer successfully";
	}

}
