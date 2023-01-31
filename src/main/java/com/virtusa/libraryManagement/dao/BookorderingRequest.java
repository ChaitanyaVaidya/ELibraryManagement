package com.virtusa.libraryManagement.dao;

import com.virtusa.libraryManagement.entites.Book;
import com.virtusa.libraryManagement.entites.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookorderingRequest {

	private Book book;
	private Payment payment;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "BookorderingRequest [book=" + book + ", payment=" + payment + "]";
	}

}
