package com.revature.Spendify.controllers;

import com.revature.Spendify.DTOs.OrderDto;
import com.revature.Spendify.entities.Order;
import com.revature.Spendify.exceptions.CartException;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.exceptions.NoAccountException;
import com.revature.Spendify.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class OrderController {
    private OrderService orderService;

    @Autowired
    OrderController(OrderService orderService){
        this.orderService=orderService;
    }

    @PostMapping("/place-order")
    public ResponseEntity<OrderDto> placeOrder(@RequestBody OrderDto order){
        if(order==null)return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        try {
            OrderDto result = orderService.placeOrder(order);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (NoAccountException e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        } catch (CartException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/get-orders/{accountName}")
    public ResponseEntity<List<OrderDto>> getOrders(@PathVariable String accountName){
        System.out.println("BARKITY BARK BARK");
        if(accountName==null)return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        try {
            List<OrderDto> result = orderService.getOrderByPurchaser(accountName);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (NoAccountException e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }

    }
}
