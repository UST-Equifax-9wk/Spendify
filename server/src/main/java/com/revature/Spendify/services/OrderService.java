package com.revature.Spendify.services;

import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Order;
import com.revature.Spendify.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

//    public Order placeOrder(Order order){
//
//    }
//
//    public List<Order> getOrderByPurchaser(String accountName){
//
//    }
//
//    public List<Order> getOrderByProvider(String accountName){
//
//    }
}
