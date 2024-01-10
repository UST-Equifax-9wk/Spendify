package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;


@Entity(name = "cart_lookup")
public class CartLookup {

    // For now a default id will work
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int cartLookUpId;

    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private int quantity;

    @ManyToOne//(cascade = CascadeType.ALL)
    //@JoinTable(name = "products",
            //joinColumns =
    @JoinColumn(name = "product_id")
    @JsonBackReference("product")
    private Product product;

    // Not sure about this relationship with cart
    @ManyToOne//(cascade = CascadeType.ALL)
    //@JoinTable(name = "carts",
    @JoinColumn(name = "cart_id")
    //@JsonBackReference("cart-cartlookup")
    private Cart cart;

    public CartLookup() {
    }

    public CartLookup(int quantity, Product product, Cart cart) {
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
    }

    public CartLookup(int cartLookUpId, int quantity, Product product, Cart cart) {
        this.cartLookUpId = cartLookUpId;
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
    }

    public int getCartLookUpId() {
        return cartLookUpId;
    }

    public void setCartLookUpId(int cartLookUpId) {
        this.cartLookUpId = cartLookUpId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
