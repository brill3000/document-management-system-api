package com.example.graphql.repository;

import com.example.graphql.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Optional<Author> findAuthorByFirstname(String firstname);
    
}
