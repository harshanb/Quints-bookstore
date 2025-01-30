package com.quints.bookstore.service;



import com.quints.bookstore.model.CheckoutItem;
import com.quints.bookstore.repository.CheckoutRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CheckoutServiceTest {

    @Autowired
    private CheckoutService checkoutService;

    @Autowired
    private CheckoutRepository checkoutRepository;

    @BeforeEach
    public void setUp() {
        // Clean up the repository before each test
        checkoutRepository.deleteAll();
    }

    @Test
    public void testAddItemsToCart() {
        CheckoutItem item1 = new CheckoutItem(1, "Book 1", "Author 1", 2, 30.0);
        CheckoutItem item2 = new CheckoutItem(2, "Book 2", "Author 2", 1, 50.0);
        List<CheckoutItem> items = List.of(item1, item2);

        List<CheckoutItem> savedItems = checkoutService.addItemsToCart(items);

        assertEquals(2, savedItems.size());
        assertEquals(2, savedItems.get(0).getQuantity());
        assertEquals("Book 1", savedItems.get(0).getTitle());
    }
}

