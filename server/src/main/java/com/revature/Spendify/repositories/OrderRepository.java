package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    public List<Order> getOrdersByAccount(Account account);
}
