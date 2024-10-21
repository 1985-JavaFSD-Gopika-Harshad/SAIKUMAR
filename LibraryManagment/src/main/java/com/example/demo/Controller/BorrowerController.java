package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Borrower;
import com.example.demo.Model.Transaction;
import com.example.demo.Service.BorrowerService;

@RestController
@RequestMapping("/borrowers")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    // Register a new borrower
    @PostMapping("/register")
    public ResponseEntity<Borrower> registerBorrower(@RequestBody Borrower borrower) {
        Borrower newBorrower = borrowerService.registerBorrower(borrower);
        return ResponseEntity.ok(newBorrower);
    }

    // Get a borrower by ID
    @GetMapping("/{id}")
    public ResponseEntity<Borrower> getBorrowerById(@PathVariable Long id) {
        Optional<Borrower> borrower = borrowerService.findBorrowerById(id);
        return borrower.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get the books borrowed by a borrower
    @GetMapping("/{id}/borrowed-books")
    public ResponseEntity<List<Transaction>> getBorrowedBooks(@PathVariable Long id) {
        List<Transaction> borrowedBooks = borrowerService.getBorrowedBooks(id);
        return ResponseEntity.ok(borrowedBooks);
    }
    @PostMapping
    public ResponseEntity<Borrower> createBorrower(@RequestBody Borrower borrower) {
        Borrower createdBorrower = borrowerService.save(borrower);
        return new ResponseEntity<>(createdBorrower, HttpStatus.CREATED);
    }
}

