package ru.security.security;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.security.security.models.Author;
import ru.security.security.models.Book;
import ru.security.security.repositories.AuthorRepository;
import ru.security.security.services.AuthorService;
import ru.security.security.services.BookService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitDatabase {

    private final AuthorService authorService;
    private final BookService bookService;
    private final AuthorRepository authorRepository;

    public InitDatabase(AuthorService authorService, BookService bookService, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    @PostConstruct
    public void addData(){
        List<Author> list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            if (i % 2 != 0) {
                Author author = new Author();
                Book book = new Book();
                author.setFirstname("AuthorName" + i);
                author.setLastname("LastnameAuthor" + i);
                book.setName("NameBook" + i);
                book.setYear_publication(1900 + i);
                authorService.addAuthor(author);
                book.setAuthor(author);
                bookService.addBook(book);
                list = authorRepository.findAll();
            } else {
                Book book = new Book();
                book.setAuthor(authorService.findAuthorById(list.get(0).getId()));
                book.setName("NameBook" + i);
                book.setYear_publication(1950 + i);
                bookService.addBook(book);
            }
        }
    }
}
