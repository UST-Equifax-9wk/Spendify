package com.revature.Spendify.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "accounts")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "distributer_flag")
    private boolean distributerFlag;

    @OneToOne(mappedBy = "account")
    private User user;

    @OneToOne(mappedBy = "account")
    private Distributer distributer;

    @OneToMany(mappedBy = "account")
    private List<Cart> cartList;

    @OneToMany(mappedBy = "account")
    private List<Product> productList;

    public Account() {
    }

    public Account(String accountName, boolean distributerFlag, User user, Distributer distributer, List<Cart> cartList, List<Product> productList) {
        this.accountName = accountName;
        this.distributerFlag = distributerFlag;
        this.user = user;
        this.distributer = distributer;
        this.cartList = cartList;
        this.productList = productList;
    }

    public Account(int accountId, String accountName, boolean distributerFlag, User user, Distributer distributer, List<Cart> cartList, List<Product> productList) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.distributerFlag = distributerFlag;
        this.user = user;
        this.distributer = distributer;
        this.cartList = cartList;
        this.productList = productList;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public boolean isDistributerFlag() {
        return distributerFlag;
    }

    public void setDistributerFlag(boolean distributerFlag) {
        this.distributerFlag = distributerFlag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Distributer getDistributer() {
        return distributer;
    }

    public void setDistributer(Distributer distributer) {
        this.distributer = distributer;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
