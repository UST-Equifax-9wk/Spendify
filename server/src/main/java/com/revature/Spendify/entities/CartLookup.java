package com.revature.Spendify.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "cart_lookup")
public class CartLookup {

    // For now a default id will work
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private int cartLookUpId;

    @Column
    private int quanity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "products",
            joinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;

    // Not sure about this relationship with cart
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "carts",
            joinColumns = @JoinColumn(name = "cart_id"))
    private List<Cart> cartList;

    public int getCartLookUpId() {
        return cartLookUpId;
    }

    public void setCartLookUpId(int cartLookUpId) {
        this.cartLookUpId = cartLookUpId;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }
}
