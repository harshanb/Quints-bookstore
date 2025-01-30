package com.quints.bookstore.service;

import com.quints.bookstore.model.BookList;
import com.quints.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @MockitoBean
    private BookRepository bookRepository;

    @Test
    public void testAddBook() {

        BookList book = new BookList();
        book.setCategory("Fiction");
        book.setAuthor("Test Author");
        book.setTitle("Test Book");
        book.setPrice(20.0);

        Mockito.when(bookRepository.save(Mockito.any(BookList.class))).thenReturn(book);
        BookList createdBook = bookService.addBook(book);

        assertEquals("Test Book", createdBook.getTitle());
        assertEquals("Test Author", createdBook.getAuthor());
    }
}
