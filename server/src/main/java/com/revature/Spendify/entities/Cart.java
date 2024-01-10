package com.revature.Spendify.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity(name = "carts")
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "is_active")
    private boolean active;

    @OneToOne(mappedBy = "cart")
    @JsonManagedReference("cart")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference("cartList")
    private Account account;

//    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
//    @JsonManagedReference("cart-cartlookup")
//    List<CartLookup> cartLookUpList;

    public Cart() {
    }

    public Cart(boolean active, Order order, Account account, List<CartLookup> cartLookUpList) {
        this.active = active;
        this.order = order;
        this.account = account;
//        this.cartLookUpList = cartLookUpList;
    }

    public Cart(int cartId, boolean active, Order order, Account account, List<CartLookup> cartLookUpList) {
        this.cartId = cartId;
        this.active = active;
        this.order = order;
        this.account = account;
//        this.cartLookUpList = cartLookUpList;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

//    public List<CartLookup> getCartLookUpList() {
//        return cartLookUpList;
//    }
//
//    public void setCartLookUpList(List<CartLookup> cartLookUpList) {
//        this.cartLookUpList = cartLookUpList;
//    }
}
