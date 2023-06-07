package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ReviewService {
    ArrayList<Review> getReviewsByProductId(int productId);
    Review addReviewForProduct (int productId, Review review);
}
