package com.revature.Spendify.entities;

import jakarta.persistence.*;

import java.util.List;

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
    private Account account;

    @ManyToMany(mappedBy = "cartList")
    List<CartLookup> cartLookUpList;

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
