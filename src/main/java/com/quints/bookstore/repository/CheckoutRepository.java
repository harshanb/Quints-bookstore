package com.quints.bookstore.repository;

import com.quints.bookstore.model.CheckoutItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutItem, Long> {
}
