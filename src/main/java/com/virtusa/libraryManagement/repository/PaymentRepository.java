package com.virtusa.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.libraryManagement.entites.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
