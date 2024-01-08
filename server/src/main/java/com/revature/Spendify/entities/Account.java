package com.revature.Spendify.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Column(name = "account_name",nullable = false)
    private String accountName;

    @Column(name = "distributor_flag", nullable = false)
    private boolean distributorFlag;

    @OneToOne(mappedBy = "account")
    @JsonBackReference(value = "user_account")
    private User user;

    @OneToOne(mappedBy = "account")
    @JsonBackReference(value = "distributor_account")
    private Distributor distributor;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference(value = "account_cart")
    private List<Cart> cartList;

    @OneToMany(mappedBy = "account")
    @JsonManagedReference(value = "account_product")
    private List<Product> productList;

    private Distributor distributer;

    public Account() {
    }

    public Account(String accountName, boolean distributorFlag, User user, Distributor distributor, List<Cart> cartList, List<Product> productList) {
        this.accountName = accountName;
        this.distributorFlag = distributorFlag;
        this.user = user;
        this.distributor = distributor;
        this.cartList = cartList;
        this.productList = productList;
    }

    public Account(int accountId, String accountName, boolean distributorFlag, User user, Distributor distributor, List<Cart> cartList, List<Product> productList) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.distributorFlag = distributorFlag;
        this.user = user;
        this.distributor = distributor;
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

    public boolean isDistributorFlag() {
        return distributorFlag;
    }

    public void setDistributorFlag(boolean distributorFlag) {
        this.distributorFlag = distributorFlag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
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
