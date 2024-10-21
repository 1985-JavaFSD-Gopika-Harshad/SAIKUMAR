package com.example.demo.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Book;
import com.example.demo.Model.Borrower;
import com.example.demo.Model.Transaction;
import com.example.demo.Repository.BorrowerRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Borrower;
import com.example.demo.Model.Transaction;
import com.example.demo.Repository.BorrowerRepository;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    // Register a new borrower
    public Borrower registerBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    // Find borrower by ID
    public Optional<Borrower> findBorrowerById(Long id) {
        return borrowerRepository.findById(id);
    }

    // Get the books borrowed by a borrower
    public List<Transaction> getBorrowedBooks(Long borrowerId) {
        Optional<Borrower> optionalBorrower = borrowerRepository.findById(borrowerId);
        if (optionalBorrower.isPresent()) {
            return optionalBorrower.get().getBorrowedBooks();
        }
        return List.of(); // Return an empty list if the borrower is not found
    }
    public Borrower save(Borrower borrower) {
       
        return borrowerRepository.save(borrower);
    }
}
