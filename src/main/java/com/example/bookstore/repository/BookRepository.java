package com.example.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>
{
	List<Book> findAllByOrderByTitleAsc();
    List<Book> findAllByOrderByTitleDesc();
    List<Book> findAllByOrderByAuthorAsc();
    List<Book> findAllByOrderByAuthorDesc();
}
