package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "reviews")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id")
    private int reviewId;

    @Column(nullable = false)
    private int rating;

    @Column
    private String reviewText;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("review")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference("reviewList-product")
    private Product product;

    public Review() {
    }

    public Review(int rating, String reviewText, User user, Product product) {
        this.rating = rating;
        this.reviewText = reviewText;
        this.user = user;
        this.product = product;
    }

    public Review(int reviewId, int rating, String reviewText, User user, Product product) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.reviewText = reviewText;
        this.user = user;
        this.product = product;
    }
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
