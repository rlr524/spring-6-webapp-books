package com.emiyaconsulting.spring6bookswebapp.services;

import com.emiyaconsulting.spring6bookswebapp.domain.Author;
import com.emiyaconsulting.spring6bookswebapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
