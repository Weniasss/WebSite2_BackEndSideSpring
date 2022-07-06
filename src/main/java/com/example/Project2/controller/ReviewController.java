package com.example.Project2.controller;


import com.example.Project2.model.Review;
import com.example.Project2.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ReviewController {
    @Autowired

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){ this.reviewService = reviewService ;}

    @PostMapping("/reviews")
    public Review createReview(@RequestBody Review review){return reviewService.createReview(review); }

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {return reviewService.getAllReviews(); }

    @DeleteMapping("/reviews/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteReview(@PathVariable Long id){
        boolean deleted = false;
        deleted = reviewService.deleteReview(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/reviews/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id){
        Review review = null;
        review = reviewService.getReviewById(id);
        return  ResponseEntity.ok(review);
    }

    @PutMapping("/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id,@RequestBody Review review){
       review = reviewService.updateReview(id,review);
       return ResponseEntity.ok(review);
    }
}
