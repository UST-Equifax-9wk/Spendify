package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(Product.Category category);

    List<Product> findByproductNameContaining(String productName);

    @Query(value = "SELECT * FROM products WHERE category = ?1 AND product_name LIKE %?2%", nativeQuery = true)
    List<Product> findByCategoryProductName(String category, String productName);
}
