package com.example.graphql.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Books {
    private @Id @Setter(AccessLevel.PROTECTED)  int id;
    private String title;

    public Books(String title) {
        this.title = title;
    }
}
