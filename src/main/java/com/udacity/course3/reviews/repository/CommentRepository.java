package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

    @Query("SELECT c FROM comment c WHERE c.review_id=:reviewId")
    ArrayList<Comment> getCommentsOnReview (int reviewId);
}
