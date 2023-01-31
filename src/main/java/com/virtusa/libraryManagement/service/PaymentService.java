package com.virtusa.libraryManagement.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.libraryManagement.dao.BookorderingRequest;
import com.virtusa.libraryManagement.entites.Book;
import com.virtusa.libraryManagement.entites.Customer;
import com.virtusa.libraryManagement.entites.Payment;
import com.virtusa.libraryManagement.repository.BookRepository;
import com.virtusa.libraryManagement.repository.CustomerRepository;
import com.virtusa.libraryManagement.repository.PaymentRepository;
import com.virtusa.libraryManagement.utils.PaymentUtils;

@Service
public class PaymentService {
	@Autowired
	public BookRepository bookRepository;
	@Autowired
	public PaymentRepository paymentRepository;

	@Transactional // (readOnly = false,isolation = Isolation.READ_COMMITTED,propagation =
					// Propagation.REQUIRED)
	public BookorderingRequest orderBook(BookorderingRequest request) {
		Book book = request.getBook();
		book = bookRepository.save(book);
		Payment payment = request.getPayment();

		PaymentUtils.validateCreditLimit(payment.getAccountNo(), book.getPrice());

		payment.setBookId(book.getBookId());
		payment.setAmount(book.getPrice());
		paymentRepository.save(payment);
		return null;

	}

//
//    @Transactional
//    public void bookOrder() {
//
//       Payment payment  = request.getPayment();
//        payment = paymentRepository.save(payment);
	// }

//@Transactional
//public void orderBook(Payment payment) {
//
//     payment.getAccountNo();
//    paymentRepository.save(payment);
//
//  
//}

}
