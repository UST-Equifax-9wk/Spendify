package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "orders")
public class Order {
    LocalDateTime now = LocalDateTime.now();
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "date_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateTime;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "card_id")
    @JsonBackReference
    private Card card;
    public Order() {
    }

    public Order(LocalDateTime dateTime, Cart cart, Card card) {
        this.dateTime = dateTime;
        this.cart = cart;
        this.card = card;
    }

    public Order(int orderId, LocalDateTime dateTime, Cart cart, Card card) {
        this.orderId = orderId;
        this.dateTime = dateTime;
        this.cart = cart;
        this.card = card;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
