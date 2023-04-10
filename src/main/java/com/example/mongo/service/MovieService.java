package com.example.mongo.service;

import com.example.mongo.entity.Movie;
import com.example.mongo.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(ObjectId id) {
        return movieRepository.findById(id).get();
    }

    public Optional<Movie> getMovieByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }
}
