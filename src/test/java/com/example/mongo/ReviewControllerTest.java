package com.example.mongo;

// this is a test class for ReviewController

import com.example.mongo.controller.ReviewController;
import com.example.mongo.entity.Movie;
import com.example.mongo.entity.Review;
import com.example.mongo.repository.MovieRepository;
import com.example.mongo.repository.ReviewRepository;
import com.example.mongo.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewControllerTest {

    @Mock
    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private ReviewController reviewController;

    private Review review;
    private Movie movie;
    private Map<String, String> payload;

    @BeforeEach
    public void setUp() {
        review = new Review();
        movie = new Movie();
        payload = new HashMap<>();
    }

    @Test
    public void createReviewTest() {
        payload.put("reviewBody", "This is a review");
        payload.put("imdbId", "tt1234567");
        when(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"))).thenReturn(review);
        ResponseEntity<Review> response = reviewController.createReview(payload);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void createReviewTest2() {
        payload.put("reviewBody", "This is a review");
        payload.put("imdbId", "tt1234567");
        when(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"))).thenReturn(review);
        ResponseEntity<Review> response = reviewController.createReview(payload);
        assertEquals(review, response.getBody());
    }

    // test for handling null review body
    @Test
    public void createReviewTest3() {
        payload.put("reviewBody", null);
        payload.put("imdbId", "tt1234567");
        when(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"))).thenReturn(review);
        ResponseEntity<Review> response = reviewController.createReview(payload);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    // test for handling null imdbId
    @Test
    public void createReviewTest4() {
        payload.put("reviewBody", "This is a review");
        payload.put("imdbId", null);
        when(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"))).thenReturn(review);
        ResponseEntity<Review> response = reviewController.createReview(payload);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    // test for handling empty review body
    @Test
    public void createReviewTest5() {
        payload.put("reviewBody", "");
        payload.put("imdbId", "tt1234567");
        when(reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"))).thenReturn(review);
        ResponseEntity<Review> response = reviewController.createReview(payload);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

}