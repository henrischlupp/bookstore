package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            log.info("Tallensin kirjoja");
            repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, 123232321L, 10.99));
            repository.save(new Book("Animal Farm", "George Orwell", 1945, 22123435L, 8.99));
        };
    }
}
