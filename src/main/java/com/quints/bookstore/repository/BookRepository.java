package com.quints.bookstore.repository;

import com.quints.bookstore.model.BookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookList, Long> {
}
