package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByAccount(Account account);

    Cart findByActiveAndAccount(Boolean active, Account account);
}
