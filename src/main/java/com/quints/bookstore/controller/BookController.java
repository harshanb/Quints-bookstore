package com.quints.bookstore.controller;

import com.quints.bookstore.model.BookList;
import com.quints.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookList> getBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookList addBook(@RequestBody BookList book) {
        return bookService.addBook(book);
    }
}
