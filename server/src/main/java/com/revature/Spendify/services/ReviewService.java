package com.revature.Spendify.services;

import com.revature.Spendify.DTOs.ReviewDto;
import com.revature.Spendify.entities.Product;
import com.revature.Spendify.entities.Review;
import com.revature.Spendify.entities.User;
import com.revature.Spendify.exceptions.InvalidReviewException;
import com.revature.Spendify.repositories.ProductRepository;
import com.revature.Spendify.repositories.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserService userService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.userService = userService;
    }

    public Review addReview(ReviewDto reviewDto, String id) throws InvalidReviewException {
        Integer productId = Integer.valueOf(id);
        Review review = new Review();
        review.setRating(reviewDto.getRating());
        review.setReviewText(reviewDto.getText());
        String accountName = reviewDto.getAccountName();
        User user = userService.findUserByAccountName(accountName);

        if(review.getRating() < 1 || review.getRating() > 5) {
            throw new InvalidReviewException("Please enter a valid rating 1-5.");
        }

        Optional<Product> product = productRepository.findById(productId);
        product.ifPresent(review::setProduct);
        review.setUser(user);

        if(this.reviewRepository.findByProductIdAndUserId(productId, user.getUserId()) != null) {
            reviewRepository.updateReview(review.getRating(), review.getReviewText(), productId, user.getUserId());
            return reviewRepository.findByProductIdAndUserId(productId, user.getUserId());
        } else {
            return reviewRepository.save(review);
        }
    }

    public List<Review> getReviewsByProductId(Integer id) {
        return reviewRepository.findReviewsByProductId(id);
    }
}
