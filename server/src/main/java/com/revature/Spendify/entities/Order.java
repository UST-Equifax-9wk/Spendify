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
    private Integer orderId;

    @Column(name = "date_time", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateTime;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @JsonBackReference("cart")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "card_id")
    @JsonBackReference("order")
    private Card card;

    @ManyToOne
    @JsonBackReference("account-orders")
    private Account account;

    public Order() {
    }

    public Order(LocalDateTime now, Integer orderId, LocalDateTime dateTime, Cart cart, Card card, Account account) {
        this.now = now;
        this.orderId = orderId;
        this.dateTime = dateTime;
        this.cart = cart;
        this.card = card;
        this.account = account;
    }

    public Order(LocalDateTime now, LocalDateTime dateTime, Cart cart, Card card, Account account) {
        this.now = now;
        this.dateTime = dateTime;
        this.cart = cart;
        this.card = card;
        this.account = account;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
