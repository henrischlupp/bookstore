package fi.haagahelia.bookstore.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;


@RestController
public class BookRestController {

    private final BookRepository bookRepository; 
   
    
    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping("/books")
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findById(@PathVariable("id") Long bookId) {
        return bookRepository.findById(bookId);
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        System.out.println("saveBook " + book);
        return bookRepository.save(book);
    }

    @PutMapping("books/{id}")
    public Book saveEditedBook(@RequestBody Book editedBook, @PathVariable Long id) {
        editedBook.setId(id);
        return bookRepository.save(editedBook);
    }
    
    @DeleteMapping("/books/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return bookRepository.findAll();
    }
}