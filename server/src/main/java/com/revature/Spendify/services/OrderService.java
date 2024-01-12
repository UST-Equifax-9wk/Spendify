package com.revature.Spendify.services;

import com.revature.Spendify.DTOs.CartWithProductsDto;
import com.revature.Spendify.DTOs.OrderDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Order;
import com.revature.Spendify.exceptions.CartException;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.exceptions.NoAccountException;
import com.revature.Spendify.repositories.CartRepository;
import com.revature.Spendify.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class OrderService {
    private OrderRepository orderRepository;
    private CartService cartService;
    private CartRepository cartRepository;
    private AccountService accountService;

    @Autowired
    public OrderService(OrderRepository orderRepository,CartService cartService,CartRepository cartRepository,AccountService accountService){
        this.orderRepository=orderRepository;
        this.cartService=cartService;
        this.cartRepository=cartRepository;
        this.accountService=accountService;
    }

    public OrderDto placeOrder(OrderDto order) throws InvalidInputException, NoAccountException, CartException {
        if(order.getOrder().getDateTime()==null)order.getOrder().setDateTime(LocalDateTime.now());
        order.getOrder().setOrderId(null);
        if(order.getOrder().getCard()==null || order.getOrder().getAccount()==null || order.getCartWithProducts()==null || order.getCartWithProducts().getProductList().isEmpty())throw new InvalidInputException(InvalidInputException.invalidInput);
        Order result = orderRepository.save(order.getOrder());
        order.setOrder(result);
        order.getOrder().getCart().setAccount(order.getOrder().getAccount());
        order.getOrder().getCart().setActive(false);
        System.out.println("----------------------"+order.getOrder().getCart().isActive());
        cartRepository.save(order.getOrder().getCart());
        cartService.createCart(order.getOrder().getAccount().getAccountName());
        return order;
    }

    public List<OrderDto> getOrderByPurchaser(String accountName) throws InvalidInputException, NoAccountException {
        if(accountName==null) throw new InvalidInputException(InvalidInputException.invalidInput);
        Account account =  accountService.findAccountByName(accountName);
        if(account==null)throw new NoAccountException(NoAccountException.noAccount);

        List<Order> orders = orderRepository.getOrdersByAccount(account);
        List<OrderDto> filled = new ArrayList<>();
        for(Order order:orders){
            OrderDto temp = new OrderDto();
            temp.setOrder(order);
            CartWithProductsDto cart = new CartWithProductsDto();
            cart.setCart(order.getCart());
            cart.setProductList(cartService.fillCart(order.getCart()));
            temp.setCartWithProducts(cart);
            filled.add(temp);
        }
        return filled;
    }

    public List<OrderDto> getOrderByProvider(String accountName){
        return null;
    }
}
