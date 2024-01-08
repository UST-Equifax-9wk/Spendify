package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.CartLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartLookupRepository extends JpaRepository<CartLookup, Integer> {
}
