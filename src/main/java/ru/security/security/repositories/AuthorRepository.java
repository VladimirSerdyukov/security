package ru.security.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.security.security.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
