package com.emiyaconsulting.spring6bookswebapp.services;

import com.emiyaconsulting.spring6bookswebapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
