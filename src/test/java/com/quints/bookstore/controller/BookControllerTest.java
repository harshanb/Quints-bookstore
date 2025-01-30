package com.quints.bookstore.controller;

import com.quints.bookstore.model.BookList;
import com.quints.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class BookControllerTest {
    @Autowired
    private BookControllerTest bookController;

    @MockitoBean
    private BookService bookService;

    private MockMvc mockMvc;

    public BookControllerTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void testGetBooks() throws Exception {
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddBook() throws Exception {
        BookList book = new BookList();
        book.setCategory("Fiction");
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setPrice(20.0);

        Mockito.when(bookService.addBook(Mockito.any(BookList.class))).thenReturn(book);

        mockMvc.perform(post("/api/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"category\":\"Fiction\",\"title\":\"Test Book\",\"author\":\"Test Author\",\"price\":20.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Book"));
    }
}
