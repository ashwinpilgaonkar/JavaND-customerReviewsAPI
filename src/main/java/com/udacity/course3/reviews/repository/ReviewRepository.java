package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.ReviewsApplication;
import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

    @Query("SELECT r FROM review r WHERE r.product_id=:productId")
    public ArrayList<Review> getReviewsByProductId(int productId);
}
