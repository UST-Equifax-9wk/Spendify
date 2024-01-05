package com.revature.Spendify.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "products")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column
    private int price;

    @Column
    private String category;

    @Column
    private double weight;

    @Column
    private int stock;

    @Column
    private double discount;

    @Column
    private String description;

    @OneToMany(mappedBy = "product")
    private List<Review> reviewList;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Product() {
    }

    public Product(String productName, int price, String category, double weight, int stock, double discount, String description, List<Review> reviewList, Cart cart, Account account) {
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.stock = stock;
        this.discount = discount;
        this.description = description;
        this.reviewList = reviewList;
        this.cart = cart;
        this.account = account;
    }

    public Product(int productId, String productName, int price, String category, double weight, int stock, double discount, String description, List<Review> reviewList, Cart cart, Account account) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.weight = weight;
        this.stock = stock;
        this.discount = discount;
        this.description = description;
        this.reviewList = reviewList;
        this.cart = cart;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
