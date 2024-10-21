package com.example.demo.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Book;
import com.example.demo.Model.Borrower;
import com.example.demo.Model.Transaction;
import com.example.demo.Repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowerService borrowerService;

    private static final double FINE_PER_DAY = 2.0;

    // Borrow a book
    public Transaction borrowBook(Long bookId, Long borrowerId) {
        if (!bookService.isBookAvailable(bookId)) {
            return null; // Book is not available for borrowing
        }

        Optional<Borrower> optionalBorrower = borrowerService.findBorrowerById(borrowerId);
        if (!optionalBorrower.isPresent()) {
            return null; // Borrower not found
        }
        Borrower borrower = optionalBorrower.get();

        Optional<Book> optionalBook = bookService.findBookById(bookId);
        if (!optionalBook.isPresent()) {
            return null; // Book not found
        }
        Book book = optionalBook.get();

        // Create a new transaction for borrowing
        Transaction transaction = new Transaction();
        transaction.setBook(book);
        transaction.setBorrower(borrower);
        transaction.setBorrowDate(LocalDate.now());
        transaction.setDueDate(LocalDate.now().plusWeeks(2)); // Due date is 2 weeks from borrow date
        transaction.setFine(0);

        // Update the book's availability
        bookService.updateBookBorrowStatus(bookId);

        return transactionRepository.save(transaction);
    }

    // Return a book and calculate fine if return is late
    public Transaction returnBook(Long transactionId, LocalDate returnDate) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        if (!optionalTransaction.isPresent()) {
            return null; // Transaction not found
        }
        Transaction transaction = optionalTransaction.get();

        LocalDate dueDate = transaction.getDueDate();

        // Calculate fine if returnDate is after dueDate
        double fine = calculateFine(returnDate, dueDate);
        transaction.setReturnDate(returnDate);
        transaction.setFine(fine);

        // Update book availability
        bookService.returnBook(transaction.getBook().getId());

        return transactionRepository.save(transaction);
    }

    // Renew a book (extend the due date)
    public Transaction renewBook(Long transactionId) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        if (!optionalTransaction.isPresent()) {
            return null; // Transaction not found
        }
        Transaction transaction = optionalTransaction.get();

        // Extend the due date by another 2 weeks
        transaction.setDueDate(transaction.getDueDate().plusWeeks(2));

        return transactionRepository.save(transaction);
    }

    // Fine calculation logic
    private double calculateFine(LocalDate returnDate, LocalDate dueDate) {
        if (returnDate.isAfter(dueDate)) {
            long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
            return daysLate * FINE_PER_DAY;
        }
        return 0;
    }
}
