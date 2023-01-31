package com.virtusa.libraryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.libraryManagement.entites.Author;
import com.virtusa.libraryManagement.entites.Customer;
import com.virtusa.libraryManagement.repository.AdminRepository;
import com.virtusa.libraryManagement.repository.AuthorRepository;
import com.virtusa.libraryManagement.repository.CustomerRepository;

@Service
public class AdminService {
	@Autowired
	public AdminRepository adminRepository;
	@Autowired
	public AuthorRepository authorRepository;
	@Autowired
	public CustomerRepository customerRepository;

	public void addAuthor(Author author) {
		authorRepository.save(author);
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void removeAuthor(Long authotId) {
		authorRepository.deleteById(authotId);

	}

	public void removeCustomer(Long customerId) {
		customerRepository.deleteById(customerId);
	}

}
