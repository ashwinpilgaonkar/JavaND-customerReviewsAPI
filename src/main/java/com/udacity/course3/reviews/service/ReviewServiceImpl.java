package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ArrayList<Review> getReviewsByProductId(int productId) {
        return reviewRepository.getReviewsByProductId(productId);
    }

    public Optional<Review> findReviewById (int reviewId) {
        return reviewRepository.findById(reviewId);
    }

    public Review addReviewForProduct (int productId, Review review) {
        review.setProductId(productId);
        return reviewRepository.save(review);
    }
}
