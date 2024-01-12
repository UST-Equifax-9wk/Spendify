package com.revature.Spendify.DTOs;

import com.revature.Spendify.entities.Order;

import java.time.LocalDateTime;

public class OrderDto {
    private Order order;
    private CartWithProductsDto cartWithProducts;

    public OrderDto() {
    }

    public OrderDto(Order order, CartWithProductsDto cartWithProducts) {
        this.order = order;
        this.cartWithProducts = cartWithProducts;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public CartWithProductsDto getCartWithProducts() {
        return cartWithProducts;
    }

    public void setCartWithProducts(CartWithProductsDto cartWithProducts) {
        this.cartWithProducts = cartWithProducts;
    }
}
