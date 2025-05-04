package ru.security.security.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.security.security.services.BookService;

@RestController
public class BookController {

    private final ObjectMapper objectMapper;
    private final BookService bookService;

    public BookController(ObjectMapper objectMapper, BookService bookService) {
        this.objectMapper = objectMapper;
        this.bookService = bookService;
    }

    @GetMapping("book/{id}")
    public ResponseEntity<String> findBookById(@PathVariable Long id) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(
                bookService.findBookById(id)
        );
        return ResponseEntity.ok(json);
    }
}
