package com.example.bookstore.service;

import com.example.bookstore.exception.ResourceNotFoundException;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService 
{
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(String sortBy, String order) 
    {
        if ("title".equalsIgnoreCase(sortBy)) 
        {
            if ("desc".equalsIgnoreCase(order)) 
            {
                return bookRepository.findAllByOrderByTitleDesc();
            } 
            else 
            {
                return bookRepository.findAllByOrderByTitleAsc();
            }
        } 
        else if ("author".equalsIgnoreCase(sortBy)) 
        {
            if ("desc".equalsIgnoreCase(order)) 
            {
                return bookRepository.findAllByOrderByAuthorDesc();
            } 
            else 
            {
                return bookRepository.findAllByOrderByAuthorAsc();
            }
        }
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) 
    {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id : " + id));
    }

    public Book createBook(Book book) 
    {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails) 
    {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id : " + id));

        if (bookDetails.getTitle() != null && !bookDetails.getTitle().isBlank()) 
        {
            book.setTitle(bookDetails.getTitle());
        }
        if (bookDetails.getAuthor() != null && !bookDetails.getAuthor().isBlank()) 
        {
            book.setAuthor(bookDetails.getAuthor());
        }
        if (bookDetails.getIsbn() != null && !bookDetails.getIsbn().isBlank()) 
        {
            book.setIsbn(bookDetails.getIsbn());
        }

        return bookRepository.save(book);
    }

    public void deleteBook(Long id) 
    {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found for this id : " + id));
        bookRepository.delete(book);
    }
}
