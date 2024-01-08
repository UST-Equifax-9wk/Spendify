package com.revature.Spendify.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "carts")
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToOne(mappedBy = "cart")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference(value = "account_cart")
    private Account account;

    @OneToMany(mappedBy = "cart")
    @JsonManagedReference(value = "cart_cartlookup")
    List<CartLookup> cartLookUpList;

    public Cart() {
    }

    public Cart(boolean isActive, Order order, Account account, List<CartLookup> cartLookUpList) {
        this.isActive = isActive;
        this.order = order;
        this.account = account;
        this.cartLookUpList = cartLookUpList;
    }

    public Cart(int cartId, boolean isActive, Order order, Account account, List<CartLookup> cartLookUpList) {
        this.cartId = cartId;
        this.isActive = isActive;
        this.order = order;
        this.account = account;
        this.cartLookUpList = cartLookUpList;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<CartLookup> getCartLookUpList() {
        return cartLookUpList;
    }

    public void setCartLookUpList(List<CartLookup> cartLookUpList) {
        this.cartLookUpList = cartLookUpList;
    }
}
