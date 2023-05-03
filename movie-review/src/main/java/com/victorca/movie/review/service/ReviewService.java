package com.victorca.movie.review.service;

import com.victorca.movie.review.model.Movie;
import com.victorca.movie.review.model.Review;
import com.victorca.movie.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    //Review is created and performs the update operation on tue Movie object
    public Review createReview(String reviewBody, String imdbId){
        Review newReview = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(newReview)).first();
        return newReview;
    }
}
