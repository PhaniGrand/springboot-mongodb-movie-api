package com.example.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    private String id;
    private String title;
    private String imdbId;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> generes;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;


}
