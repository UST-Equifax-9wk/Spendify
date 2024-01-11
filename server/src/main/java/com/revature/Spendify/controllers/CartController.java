package com.revature.Spendify.controllers;

import com.revature.Spendify.DTOs.CartWithProductsDto;
import com.revature.Spendify.entities.Cart;
import com.revature.Spendify.entities.CartLookup;
import com.revature.Spendify.exceptions.CartException;
import com.revature.Spendify.exceptions.NoAccountException;
import com.revature.Spendify.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CartController {
    private CartService cartService;

    @Autowired
    CartController(CartService cartService){
        this.cartService=cartService;
    }

    @GetMapping("/{accountName}/cart")
    public ResponseEntity<CartWithProductsDto> getActiveCart(@PathVariable String accountName){
        //if no accountName return 417
        if(accountName.isEmpty())return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        try {
            CartWithProductsDto cart = cartService.findActiveCart(accountName);
            return new ResponseEntity<>(cart,HttpStatus.OK);
        } catch (NoAccountException e) {
            //return 400 if no account exists
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/{accountName}/cart/edit")
    public ResponseEntity<CartWithProductsDto> addToActiveCart(@PathVariable String accountName , @RequestBody CartLookup lookup) {
        if (accountName.isEmpty() || lookup == null) return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        try {
            CartWithProductsDto result = cartService.editCart(lookup,accountName);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (CartException e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        } catch (NoAccountException e) {
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }
    }
}
