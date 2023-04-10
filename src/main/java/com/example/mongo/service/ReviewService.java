package com.example.mongo.service;

import com.example.mongo.entity.Movie;
import com.example.mongo.entity.Review;
import com.example.mongo.repository.ReviewRepository;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {


    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void getReviews() {
        reviewRepository.findAll();
    }

    public Review getReviewById(ObjectId id) {
        return reviewRepository.findById(id).get();
    }

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        UpdateResult first = mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds", review.getId()))
                .first();

        return review;
    }
}
