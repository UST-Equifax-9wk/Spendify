package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "cards")
public class Card {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "card_id")
    private int cardId;

    @Column(nullable = false)
    private String name;

    @Column(name = "card_number",nullable = false)
    private String cardNumber;

    @Column(name = "expiration_date",nullable = false)
    private String expirationDate;

    @OneToMany(mappedBy = "card")
    @JsonManagedReference("order")
    private List<Order> orderList;

    // Foreign key
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user")
    private User user;

    public Card() {
    }

    public Card(String name, String cardNumber, String expirationDate, List<Order> orderList, User user) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.orderList = orderList;
        this.user = user;
    }

    public Card(int cardId, String name, String cardNumber, String expirationDate, List<Order> orderList, User user) {
        this.cardId = cardId;
        this.name = name;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.orderList = orderList;
        this.user = user;
    }
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
