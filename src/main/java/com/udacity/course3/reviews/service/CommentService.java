package com.udacity.course3.reviews.service;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface CommentService {

     Comment addCommentToReview(int reviewId, Comment comment);

    ArrayList<Comment> getCommentsOnReview(int reviewId);
}
