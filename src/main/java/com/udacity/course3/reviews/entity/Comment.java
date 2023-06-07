package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity (name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "commenter_name")
    private String commenter_name;

    @Column(name = "comment_text")
    private String comment_text;

    @Column(name = "review_id", insertable = false, updatable = false)
    private int review_id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    @JsonIgnore
    private Review review;

    public Comment() {
    }

    public String getCommenterName() {
        return commenter_name;
    }

    public void setCommenterName(String commenter_name) {
        this.commenter_name = commenter_name;
    }

    public String getCommentText() {
        return this.comment_text;
    }

    public void setCommentText(String comment_text) {
        this.comment_text = comment_text;
    }

    public int getReview_id() {
        return this.review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public Review getReview() {
        return this.review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
