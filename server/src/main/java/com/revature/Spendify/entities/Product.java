package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.List;

@Entity(name = "products")
public class Product {
    enum Category{
        TECH,
        PETS,
        GROCERIES,
        CLEANING
    }
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private Category category;

    @Column
    private double weight;

    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private int stock;

    @Column
    private double discount;

    @Column
    private String description;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Review> reviewList;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;

    @ManyToMany(mappedBy = "productList")
    @JsonManagedReference
    private List<CartLookup> cartLookupList;
    public Product() {
    }

    public Product(String productName, double price, Category category, double weight, int stock, double discount, String description, List<Review> reviewList, Account account) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.stock = stock;
        this.discount = discount;
        this.description = description;
        this.reviewList = reviewList;
        this.account = account;
    }

    public Product(int productId, String productName, double price, Category category, double weight, int stock, double discount, String description, List<Review> reviewList, Account account) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.stock = stock;
        this.discount = discount;
        this.description = description;
        this.reviewList = reviewList;
        this.account = account;
    }
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<CartLookup> getCartLookupList() {
        return cartLookupList;
    }

    public void setCartLookupList(List<CartLookup> cartLookupList) {
        this.cartLookupList = cartLookupList;
    }
}
