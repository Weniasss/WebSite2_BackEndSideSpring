package com.example.Project2.services;


import com.example.Project2.entity.ReviewEntity;
import com.example.Project2.model.Review;
import com.example.Project2.repository.ReviewRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService{
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){ this.reviewRepository = reviewRepository;}

    @Override
    public Review createReview(Review review) {
        ReviewEntity reviewEntity = new ReviewEntity();

        BeanUtils.copyProperties(review,reviewEntity);
        reviewRepository.save(reviewEntity);
        return review;
    }

    @Override
    public List<Review> getAllReviews() {

        List<ReviewEntity> reviewEntities = reviewRepository.findAll();

        List<Review> reviews = reviewEntities.stream().map(emp -> new Review(
                emp.getId(),
                emp.getUserName(),
                emp.getUserRating(),
                emp.getUserComment()))
                .collect(Collectors.toList());

        return reviews;
    }

    @Override
    public boolean deleteReview(Long id) {
        ReviewEntity review = reviewRepository.findById(id).get();
        reviewRepository.delete(review);
        return true;
    }

    @Override
    public Review getReviewById(Long id) {
        ReviewEntity reviewEntity = reviewRepository.findById(id).get();
        Review review = new Review();
        BeanUtils.copyProperties(reviewEntity,review);
        return review;
    }

    @Override
    public Review updateReview(Long id, Review review) {
        ReviewEntity reviewEntity = reviewRepository.findById(id).get();
        reviewEntity.setUserName(review.getUserName());
        reviewEntity.setUserRating(review.getUserRating());
        reviewEntity.setUserComment(review.getUserComment());

        reviewRepository.save(reviewEntity);
        return review;
    }



}
