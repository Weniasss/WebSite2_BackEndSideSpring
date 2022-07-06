package com.example.Project2.services;

import java.util.List;

import com.example.Project2.model.Employee;
import com.example.Project2.model.Review;

public interface ReviewService {
    Review createReview(Review review);

    List<Review> getAllReviews();

    boolean deleteReview(Long id);

    Review getReviewById(Long id);

    Review updateReview(Long id, Review review);
}
