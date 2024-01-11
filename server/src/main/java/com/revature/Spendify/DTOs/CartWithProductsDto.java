package com.revature.Spendify.DTOs;

import com.revature.Spendify.entities.Cart;
import com.revature.Spendify.entities.CartLookup;

import java.util.List;

public class CartWithProductsDto {
    private Cart cart;
    private List<CartLookup> productList;

    public CartWithProductsDto() {
    }

    public CartWithProductsDto(Cart cart, List<CartLookup> productList) {
        this.cart = cart;
        this.productList = productList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<CartLookup> getProductList() {
        return productList;
    }

    public void setProductList(List<CartLookup> productList) {
        this.productList = productList;
    }
}
