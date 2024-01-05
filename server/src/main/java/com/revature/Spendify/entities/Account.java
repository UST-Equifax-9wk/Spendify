package com.revature.Spendify.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "accounts")
public class Account {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "distributor_flag")
    private boolean distributerFlag;

    @OneToOne(mappedBy = "account")
    private User user;

    @OneToOne(mappedBy = "account")
    private Distributor distributer;

    @OneToMany(mappedBy = "account")
    private List<Cart> cartList;

    @OneToMany(mappedBy = "account")
    private List<Product> productList;

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

    public Distributor getDistributor() {
        return distributer;
    }

    public void setDistributor(Distributor distributer) {
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
