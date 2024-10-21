package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	 List<Transaction> findByBorrowerIdAndReturnDateIsNull(Long borrowerId);
}
