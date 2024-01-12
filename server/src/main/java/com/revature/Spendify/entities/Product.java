package com.revature.Spendify.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity(name = "products")
public class Product {
    public enum Category{
        TECH,
        PETS,
        GROCERIES,
        CLEANING,
        KITCHEN,
        OFFICE,
        CLOTHES,
        FOOTWEAR
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
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    private double weight;

    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private int stock;

    @Column
    private double discount;

    @Column
    private String description;

    @Column
    private Boolean biddable;

    @Column
    private Integer threshold;

    @Column
    private Double currentBid;

    @ManyToOne
    @JoinColumn(name = "current_bidder_account_id")
    @JsonBackReference("bidList")
    private Account currentBidder;

    public Double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(Double currentBid) {
        this.currentBid = currentBid;
    }

    public Account getCurrentBidder() {
        return currentBidder;
    }

    public void setCurrentBidder(Account currentBidder) {
        this.currentBidder = currentBidder;
    }

    public Boolean getBiddable() {
        return biddable;
    }

    public void setBiddable(Boolean biddable) {
        this.biddable = biddable;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    @OneToMany(mappedBy = "product")
    @JsonManagedReference("reviewList-product")
    private List<Review> reviewList;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference("productList")
    private Account account;

//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//    @JsonManagedReference("product")
//    private List<CartLookup> cartLookupList;
    public Product() {
    }

    public Product(String productName, double price, Category category, double weight, int stock, double discount, String description, Boolean biddable, Integer threshold, Account currentBidder, List<Review> reviewList, Account account, Double currentBid) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.stock = stock;
        this.discount = discount;
        this.description = description;
        this.biddable = biddable;
        this.threshold = threshold;
        this.currentBidder = currentBidder;
        this.reviewList = reviewList;
        this.account = account;
        this.currentBid = currentBid;
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

//    public List<CartLookup> getCartLookupList() {
//        return cartLookupList;
//    }
//
//    public void setCartLookupList(List<CartLookup> cartLookupList) {
//        this.cartLookupList = cartLookupList;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", weight=" + weight +
                ", stock=" + stock +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                ", reviewList=" + reviewList +
                ", account=" + account +
//                ", cartLookupList=" + cartLookupList +
                '}';
    }
}
