package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.Card;
import com.revature.Spendify.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
    public List<Card> findByUser(User user);
}
