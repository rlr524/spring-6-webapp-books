package com.emiyaconsulting.spring6bookswebapp.repositories;

import com.emiyaconsulting.spring6bookswebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
