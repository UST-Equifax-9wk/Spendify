package com.revature.Spendify.entities;

import jakarta.persistence.*;

@Entity(name = "reviews")
public class Review {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id")
    private int reviewId;

    @Column
    private int rating;

    @Column
    private String review;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Review() {
    }

    public Review(int rating, String review, User user, Product product) {
        this.rating = rating;
        this.review = review;
        this.user = user;
        this.product = product;
    }

    public Review(int reviewId, int rating, String review, User user, Product product) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.review = review;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
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
