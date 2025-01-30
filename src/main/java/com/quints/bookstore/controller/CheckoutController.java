package com.quints.bookstore.controller;

import com.quints.bookstore.model.CheckoutItem;
import com.quints.bookstore.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;


    @PostMapping
    public List<CheckoutItem> addItemsToCart(@RequestBody List<CheckoutItem> items) {
        return checkoutService.addItemsToCart(items);
    }
    // Get all cart items
    @GetMapping
    public List<CheckoutItem> getCartItems() {
        return checkoutService.getAllCartItems();
    }
}
