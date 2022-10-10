package com.example.graphql.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Data
public class Author {
    private @Id @Setter(AccessLevel.PROTECTED)  String id;
    @Indexed(unique = false)
    private String firstname;
    @Indexed(unique = false)
    private String lastname;
    private List<Books> books;

    public Author(String firstname, String lastname, List<Books> books) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.books = books;
    }
}
