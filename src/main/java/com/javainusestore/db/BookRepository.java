package com.javainusestore.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainusestore.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}
