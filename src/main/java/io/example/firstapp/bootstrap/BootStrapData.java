package io.example.firstapp.bootstrap;

import io.example.firstapp.domain.Author;
import io.example.firstapp.domain.Book;
import io.example.firstapp.domain.Publisher;
import io.example.firstapp.repositories.AuthorRepository;
import io.example.firstapp.repositories.BookRepository;
import io.example.firstapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap start . . .");



        Author a1 = new Author();
        a1.setFirstName("Tommaso");
        a1.setLastName("Galimberti");
        Author a1Saved = authorRepository.save(a1);

        Author a2 = new Author();
        a2.setFirstName("Giorgio");
        a2.setLastName("Ercolano");
        Author a2Saved = authorRepository.save(a2);


        Publisher p1 = new Publisher();
        p1.setPublisherName("Giorgio");
        p1.setCity("Milano");
        p1.setAddress("Via Giorgio");
        p1.setZipCode("iut4oihghgg4oiri");
        p1.setState("Napoli");
        Publisher p1Saved = publisherRepository.save(p1);

        Book b1 = new Book();
        b1.setTitle("In cucina con Ciccio");
        b1.setIsbn("AHD23");
        b1.setPublisher(p1Saved);
        Book b1Saved = bookRepository.save(b1);

        Book b2 = new Book();
        b2.setTitle("Fortnaito");
        b2.setIsbn("UwUBa");
        b2.setPublisher(p1Saved);
        Book b2Saved = bookRepository.save(b2);

        System.out.println("Bootstrap End . . . ");

    }
}
