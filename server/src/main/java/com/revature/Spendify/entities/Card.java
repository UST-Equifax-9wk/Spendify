package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

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

    @OneToOne(mappedBy = "card")
    @JsonManagedReference("order")
    private Order order;

    // Foreign key
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user")
    private User user;

    public Card() {
    }

    public Card(String name, String cardNumber, String expirationDate, Order order, User user) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.order = order;
        this.user = user;
    }

    public Card(int cardId, String name, String cardNumber, String expirationDate, Order order, User user) {
        this.cardId = cardId;
        this.name = name;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
