package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "reviewer_name")
    private String reviewer_name;

    @Column(name = "review_text")
    private String review_text;

    @Column(name = "stars")
    private Double stars;

    @Column(name = "product_id", insertable = false, updatable = false)
    private int product_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @OneToMany(mappedBy = "review")
    private List<Comment> commentList;

    public Review() {
    }

    public String getReviewerName() {
        return reviewer_name;
    }

    public void setReviewerName(String reviewer_name) {
        this.reviewer_name = reviewer_name;
    }

    public String getReviewText() {
        return review_text;
    }

    public void setReviewText(String review_text) {
        this.review_text = review_text;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public int getProductId() {
        return this.product_id;
    }
    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Comment> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
