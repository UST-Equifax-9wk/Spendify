package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.Cart;
import com.revature.Spendify.entities.CartLookup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartLookupRepository extends JpaRepository<CartLookup, Integer> {
    List<CartLookup> findByCart(Cart cart);
}
