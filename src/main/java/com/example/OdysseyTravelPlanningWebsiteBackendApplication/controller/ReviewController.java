package com.example.OdysseyTravelPlanningWebsiteBackendApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Review;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Add a review
    @PostMapping("/addReview")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review savedReview = reviewService.addReview(review);
        return ResponseEntity.ok(savedReview);
    }

    // Get all reviews
    @GetMapping("/getAllReviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    // Get a review by ID
    @GetMapping("getReviewById/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable String id) {
        return reviewService.getReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a review
    @PutMapping("updateReview/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String id, @RequestBody Review updatedReview) {
        try {
            Review savedReview = reviewService.updateReview(id, updatedReview);
            return ResponseEntity.ok(savedReview);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a review
    @DeleteMapping("deleteReview/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id) {
    try {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully!");
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found with ID: " + id);
    }
    }
}
