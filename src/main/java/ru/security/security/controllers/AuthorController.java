package ru.security.security.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.security.security.services.AuthorService;

@RestController
public class AuthorController {

    private final AuthorService authorService;
    private final ObjectMapper objectMapper;

    public AuthorController(AuthorService authorService, ObjectMapper objectMapper) {
        this.authorService = authorService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<String> findAuthorById(@PathVariable Long id) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(
        authorService.findAuthorById(id)
        );
        return ResponseEntity.ok(json);
    }

    @GetMapping("/author/all")
    public ResponseEntity<String> getAllAuthor() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(authorService.getAllAuthor()));
    }
}
