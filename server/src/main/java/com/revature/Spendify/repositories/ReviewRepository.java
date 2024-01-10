package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "SELECT * FROM reviews WHERE product_id = ?1 AND user_id = ?2", nativeQuery = true)
    public Review findByProductIdAndUserId(Integer productId, Integer userId);

    @Modifying
    @Query(value = "UPDATE reviews SET rating = ?1, review_text = ?2 WHERE product_id = ?3 AND user_id = ?4", nativeQuery = true)
    public void updateReview(Integer rating, String text, Integer productId, Integer userId);

}
