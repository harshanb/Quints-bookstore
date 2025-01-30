package com.quints.bookstore.service;

import com.quints.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.quints.bookstore.model.BookList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository  bookRepository;

    public List<BookList> getAllBooks() {
        return bookRepository.findAll();
    }
    public BookList addBook(BookList book) {
        return bookRepository.save(book);
    }
}
