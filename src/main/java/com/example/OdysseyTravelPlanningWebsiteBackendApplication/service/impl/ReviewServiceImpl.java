package com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OdysseyTravelPlanningWebsiteBackendApplication.model.Review;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.repo.ReviewRepository;
import com.example.OdysseyTravelPlanningWebsiteBackendApplication.service.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(String id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review updateReview(String id, Review updatedReview) {
        return reviewRepository.findById(id).map(existingReview -> {
            existingReview.setReviewerName(updatedReview.getReviewerName());
            existingReview.setRate(updatedReview.getRate());
            existingReview.setComment(updatedReview.getComment());
            return reviewRepository.save(existingReview);
        }).orElseThrow(() -> new RuntimeException("Review not found with ID: " + id));
    }

    @Override
    public void deleteReview(String id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found with ID: " + id);
        }
        reviewRepository.deleteById(id);
    }
}

