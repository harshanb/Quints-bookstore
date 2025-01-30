package com.quints.bookstore.service;


import com.quints.bookstore.model.CheckoutItem;
import com.quints.bookstore.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    // Add items for checkout and persist in the database
    public List<CheckoutItem> addItemsToCart(List<CheckoutItem> items) {
        items.forEach(item -> {
            checkoutRepository.save(item);
        });
        return checkoutRepository.findAll();
    }
    // Get all cart items
    public List<CheckoutItem> getAllCartItems() {
        return checkoutRepository.findAll();
    }
}
