package com.example.demo.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Transaction;
import com.example.demo.Service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Borrow a book
    @PostMapping("/borrow")
    public ResponseEntity<Transaction> borrowBook(@RequestParam Long bookId, @RequestParam Long borrowerId) {
        Transaction transaction = transactionService.borrowBook(bookId, borrowerId);
        return ResponseEntity.ok(transaction);
    }

    // Return a book
    @PostMapping("/return/{transactionId}")
    public ResponseEntity<Transaction> returnBook(@PathVariable Long transactionId, @RequestParam LocalDate returnDate) {
        Transaction updatedTransaction = transactionService.returnBook(transactionId, returnDate);
        return ResponseEntity.ok(updatedTransaction);
    }

    // Renew a book
    @PostMapping("/renew/{transactionId}")
    public ResponseEntity<Transaction> renewBook(@PathVariable Long transactionId) {
        Transaction renewedTransaction = transactionService.renewBook(transactionId);
        return ResponseEntity.ok(renewedTransaction);
    }

    // Get fine for a specific transaction (if any)
//    @GetMapping("/{transactionId}/fine")
//    public ResponseEntity<Double> getFineForTransaction(@PathVariable Long transactionId) {
//        Transaction transaction = transactionService.findTransactionById(transactionId);
//        return ResponseEntity.ok(transaction.getFine());
//    }
}
