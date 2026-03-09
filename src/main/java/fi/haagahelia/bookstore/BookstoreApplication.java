package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.CategoryRepository;
import fi.haagahelia.bookstore.domain.Category;

@SpringBootApplication
public class BookstoreApplication {

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
        return (args) -> {
            log.info("Tallennetaan testidataa...");

            // Kategoriat
            Category c1 = new Category("Children");
            Category c2 = new Category("Fantasy");
            Category c3 = new Category("History");
            Category c4 = new Category("Science Fiction");
            Category c5 = new Category("Classic");

            crepository.save(c1);
            crepository.save(c2);
            crepository.save(c3);
            crepository.save(c4);
            crepository.save(c5);

            // Kirjat
            repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, 123232321L, 10.99, c5));
            repository.save(new Book("Animal Farm", "George Orwell", 1945, 22123435L, 8.99, c5));
            repository.save(new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1997, 9780747532743L, 12.99, c2));
            repository.save(new Book("The Hobbit", "J.R.R. Tolkien", 1937, 9780547928227L, 14.99, c2));
            repository.save(new Book("Dune", "Frank Herbert", 1965, 9780441172719L, 15.99, c4));
            repository.save(new Book("The Little Prince", "Antoine de Saint-Exupéry", 1943, 9780156013987L, 9.99, c1));
            repository.save(new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2011, 9780062316097L, 18.99, c3));

            log.info("Testidata lisätty");
        };
    }
}