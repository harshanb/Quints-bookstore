package com.quints.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class CheckoutItem {

    @Id
    private int id;
    private String title;
    private String author;
    private int quantity;
    private double price;

    // Constructor, Getters and Setters
    public CheckoutItem(int id, String title, String author, int quantity, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }
    // Default constructor
    public CheckoutItem() {
        // No-argument constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
