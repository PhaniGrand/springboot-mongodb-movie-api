package com.example.mongo.controller;

import com.example.mongo.entity.Movie;
import com.example.mongo.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000, http://10.5.0.2:3000", allowCredentials = "true", allowedHeaders = "*")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping

    public ResponseEntity<List<Movie>> getMovies() {
        //movieService.getMovies();
        return new ResponseEntity<List<Movie>>(movieService.getMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable ObjectId id) {
        return new ResponseEntity<Movie>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
