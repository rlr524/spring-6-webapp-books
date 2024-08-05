package com.emiyaconsulting.spring6bookswebapp.repositories;

import com.emiyaconsulting.spring6bookswebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
}
