package com.emiyaconsulting.spring6bookswebapp.services;

import com.emiyaconsulting.spring6bookswebapp.domain.Book;
import com.emiyaconsulting.spring6bookswebapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
