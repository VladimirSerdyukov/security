package ru.security.security.services;


import org.springframework.stereotype.Service;
import ru.security.security.models.Book;
import ru.security.security.repositories.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(Long id){
        return bookRepository.findById(id).orElse(new Book());
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }
}
