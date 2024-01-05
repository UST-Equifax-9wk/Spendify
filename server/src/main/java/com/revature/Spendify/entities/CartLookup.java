package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity(name = "cart_lookup")
public class CartLookup {

    // For now a default id will work
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int cartLookUpId;

    @Column(columnDefinition = "INTEGER DEFAULT 1")
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "products",
            joinColumns = @JoinColumn(name = "product_id"))
    @JsonBackReference
    private Product product;

    // Not sure about this relationship with cart
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "carts",
            joinColumns = @JoinColumn(name = "cart_id"))
    @JsonBackReference
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
