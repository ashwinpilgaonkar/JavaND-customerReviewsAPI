package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentServiceImpl implements CommentService{
    CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addCommentToReview(int reviewId, Comment comment) {
        comment.setReview_id(reviewId);
        return commentRepository.save(comment);
    }

    public ArrayList<Comment> getCommentsOnReview(int reviewId) {
        return commentRepository.getCommentsOnReview(reviewId);
    }
}
