package com.example.demo.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Book;
import com.example.demo.Repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Add a new book to the library
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Find a book by ID
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Check if a book is available
    public boolean isBookAvailable(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            return optionalBook.get().getAvailableCopies() > 0;
        }
        return false; // Book not found
    }

    // Update the borrow status by decreasing available copies
    public boolean updateBookBorrowStatus(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            if (book.getAvailableCopies() > 0) {
                book.setAvailableCopies(book.getAvailableCopies() - 1);
                bookRepository.save(book);
                return true; // Successful borrow
            } else {
                return false; // No copies available
            }
        }
        return false; // Book not found
    }

    // Return a book and update the availability
    public boolean returnBook(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            bookRepository.save(book);
            return true; // Successful return
        }
        return false; // Book not found
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // Assuming you have a findAll method in your BookRepository
    }
    public void deletebyid(Long id) {
    	bookRepository.deleteById(id);
    }
}
