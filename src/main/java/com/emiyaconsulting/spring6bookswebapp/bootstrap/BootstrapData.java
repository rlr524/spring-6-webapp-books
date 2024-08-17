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
        // Create 1Q84, Haruki Murakami and save to repos
        Author haruki = new Author();
        haruki.setFirstName("Haruki");
        haruki.setLastName("Murakami");

        Book oneq = new Book();
        oneq.setTitle("1Q84");
        oneq.setIsbn("978-0307476463");

        Author harukiSaved = authorRepository.save(haruki);
        Book oneqSaved = bookRepository.save(oneq);

        // Create Three Body Problem, Cixin Liu and save to repos
        Author cixin = new Author();
        cixin.setFirstName("Cixin");
        cixin.setLastName("Liu");

        Book three = new Book();
        three.setTitle("Three Body Problem");
        three.setIsbn("978-0765382030");

        Author cixinSaved = authorRepository.save(cixin);
        Book threeSaved = bookRepository.save(three);

        // Commit the author and book records
        cixinSaved.getBooks().add(threeSaved);
        harukiSaved.getBooks().add(oneqSaved);
        threeSaved.getAuthors().add(cixinSaved);
        oneqSaved.getAuthors().add(harukiSaved);

        // Create the publishers
        Publisher vintage = new Publisher();
        vintage.setPublisherName("Vintage Press");
        vintage.setAddress("456 Main");

        Publisher tor = new Publisher();
        tor.setPublisherName("Tor Books");
        tor.setAddress("123 Main");

        // Save the pblishers to their repos and commit the publishers to their books
        Publisher savedPubVintage = publisherRepository.save(vintage);
        Publisher savedPubTor = publisherRepository.save(tor);
        oneqSaved.setPublisher(savedPubVintage);
        threeSaved.setPublisher(savedPubTor);


        // Create the hash sets for the author objects
//        Set<Author> threeAuthors = new HashSet<>();
//        threeAuthors.add(cixinSaved);
//        Set<Author> oneqAuthors = new HashSet<>();
//        oneqAuthors.add(harukiSaved);

        // Link the publishers and authors to the books

//        oneqSaved.setAuthors(oneqAuthors);
//        threeSaved.setAuthors(threeAuthors);

//        harukiSaved.getBooks().add(oneqSaved);
//        cixinSaved.getBooks().add(threeSaved);

        // Commit the author and book data to the db
        authorRepository.save(harukiSaved);
        authorRepository.save(cixinSaved);
        bookRepository.save(oneqSaved);
        bookRepository.save(threeSaved);

        System.out.printf("Author count: %d\n", authorRepository.count());
        System.out.printf("Book count: %d\n", bookRepository.count());
        System.out.printf("Publisher count: %d\n", publisherRepository.count());
    }
}
