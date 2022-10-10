package com.example.graphql.controller;

import com.example.graphql.model.Author;
import com.example.graphql.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor

public class AuthorController {

    private final AuthorRepository authorRepository;

    @QueryMapping
    Iterable<Author> authors(){
        return authorRepository.findAll();
    }
}
