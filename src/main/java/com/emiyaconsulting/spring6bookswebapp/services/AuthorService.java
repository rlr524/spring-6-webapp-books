package com.emiyaconsulting.spring6bookswebapp.services;

import com.emiyaconsulting.spring6bookswebapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
