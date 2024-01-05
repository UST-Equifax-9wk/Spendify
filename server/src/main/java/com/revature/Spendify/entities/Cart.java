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

    @OneToMany(mappedBy = "cart")
    List<Product> productList;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Cart() {
    }

    public Cart(boolean isActive, Order order, List<Product> productList, Account account) {
        this.isActive = isActive;
        this.order = order;
        this.productList = productList;
        this.account = account;
    }

    public Cart(int cartId, boolean isActive, Order order, List<Product> productList, Account account) {
        this.cartId = cartId;
        this.isActive = isActive;
        this.order = order;
        this.productList = productList;
        this.account = account;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
