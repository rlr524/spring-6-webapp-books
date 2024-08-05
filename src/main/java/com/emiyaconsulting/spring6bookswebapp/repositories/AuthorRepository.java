package com.emiyaconsulting.spring6bookswebapp.repositories;

import com.emiyaconsulting.spring6bookswebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
