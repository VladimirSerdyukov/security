package ru.security.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.security.security.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
