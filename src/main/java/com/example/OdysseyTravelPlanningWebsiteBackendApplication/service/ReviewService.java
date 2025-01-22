package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service;

import java.util.List;
import java.util.Optional;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Review;

public interface ReviewService {
    Review addReview(Review review);
    List<Review> getAllReviews();
    Optional<Review> getReviewById(String id);
    Review updateReview(String id, Review updatedReview);
    void deleteReview(String id);
    public List<Review> getReviewsByReviewdItemId(String reviewdItemId);
}
