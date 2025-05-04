package ru.security.security.services;

import org.springframework.stereotype.Service;
import ru.security.security.models.Author;
import ru.security.security.repositories.AuthorRepository;

import java.util.List;
import java.util.function.Supplier;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author findAuthorById(Long id){
        // здесь можно переобуть сущность в DTO
        return authorRepository.findById(id).orElse(new Author());
    }

    public void addAuthor(Author author){
        authorRepository.save(author);
    }

    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }
}
