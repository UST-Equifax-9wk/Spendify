package com.revature.Spendify.controllers;

import com.revature.Spendify.DTOs.ReviewDto;
import com.revature.Spendify.entities.Review;
import com.revature.Spendify.exceptions.InvalidReviewException;
import com.revature.Spendify.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(path="/products/{productId}/reviews")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Review postReview(@PathVariable String productId, @RequestBody ReviewDto reviewDto) throws InvalidReviewException {
        return reviewService.addReview(reviewDto, productId);
    }

    @GetMapping(path = "/products/{productId}/reviews")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Review> findReviewsByProductId(@PathVariable String productId) {
        return reviewService.getReviewsByProductId(Integer.parseInt(productId));
    }
}
