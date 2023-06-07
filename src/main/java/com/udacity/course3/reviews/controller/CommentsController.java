package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.service.CommentService;
import com.udacity.course3.reviews.service.CommentServiceImpl;
import com.udacity.course3.reviews.service.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    // xTODO: Wire needed JPA repositories here

    CommentServiceImpl commentService;
    ReviewServiceImpl reviewService;

    public CommentsController(CommentServiceImpl commentService, ReviewServiceImpl reviewService) {
        this.commentService = commentService;
        this.reviewService = reviewService;
    }

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<Comment> createCommentForReview(@PathVariable("reviewId") int reviewId, @RequestBody Comment comment) {

        Optional<Review> optionalReview = reviewService.findReviewById(reviewId);
        if(optionalReview.isPresent()) {
            return new ResponseEntity<Comment>(commentService.addCommentToReview(reviewId, comment), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Comment>(new Comment(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> listCommentsForReview(@PathVariable("reviewId") int reviewId) {

        Optional<Review> optionalReview = reviewService.findReviewById(reviewId);

        if(optionalReview.isPresent()) {
            return new ResponseEntity<List<Comment>>(commentService.getCommentsOnReview(reviewId), HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Comment>>(Arrays.asList(new Comment()), HttpStatus.NOT_FOUND);
        }
    }
}