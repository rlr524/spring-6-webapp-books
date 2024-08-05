package com.emiyaconsulting.spring6bookswebapp.bootstrap;

import com.emiyaconsulting.spring6bookswebapp.domain.Author;
import com.emiyaconsulting.spring6bookswebapp.domain.Book;
import com.emiyaconsulting.spring6bookswebapp.domain.Publisher;
import com.emiyaconsulting.spring6bookswebapp.repositories.AuthorRepository;
import com.emiyaconsulting.spring6bookswebapp.repositories.BookRepository;
import com.emiyaconsulting.spring6bookswebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author haruki = new Author();
        haruki.setFirstName("Haruki");
        haruki.setLastName("Murakami");

        Book oneq = new Book();
        oneq.setTitle("1Q84");
        oneq.setIsbn("978-0307476463");

        Author harukiSaved = authorRepository.save(haruki);
        Book oneqSaved = bookRepository.save(oneq);

        Author cixin = new Author();
        cixin.setFirstName("Cixin");
        cixin.setLastName("Liu");

        Book three = new Book();
        three.setTitle("Three Body Problem");
        three.setIsbn("978-0765382030");

        Publisher tor = new Publisher();
        tor.setPublisherName("Tor Books");

        Publisher vintage = new Publisher();
        vintage.setPublisherName("Vintage Press");

        Author cixinSaved = authorRepository.save(cixin);
        Book threeSaved = bookRepository.save(three);

        Publisher torSaved = publisherRepository.save(tor);
        Publisher vintageSaved = publisherRepository.save(vintage);

        harukiSaved.getBooks().add(oneqSaved);
        cixinSaved.getBooks().add(threeSaved);

        torSaved.getBooks().add(threeSaved);
        vintageSaved.getBooks().add(oneqSaved);

        authorRepository.save(harukiSaved);
        authorRepository.save(cixinSaved);

        System.out.printf("Author count: %d\n", authorRepository.count());
        System.out.printf("Book count: %d\n", bookRepository.count());
        System.out.printf("Publisher count: %d\n", publisherRepository.count());
    }
}
