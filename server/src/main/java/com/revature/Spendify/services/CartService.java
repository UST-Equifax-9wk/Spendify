package com.revature.Spendify.services;

import com.revature.Spendify.DTOs.CartWithProductsDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Cart;
import com.revature.Spendify.entities.CartLookup;
import com.revature.Spendify.entities.Product;
import com.revature.Spendify.exceptions.CartException;
import com.revature.Spendify.exceptions.NoAccountException;
import com.revature.Spendify.repositories.CartLookupRepository;
import com.revature.Spendify.repositories.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class CartService {
    private CartRepository cartRepository;
    private AccountService accountService;
    private CartLookupRepository cartLookupRepository;

    @Lazy
    @Autowired
    CartService(CartRepository cartRepository, AccountService accountService, CartLookupRepository cartLookupRepository){
        this.cartRepository=cartRepository;
        this.accountService=accountService;
        this.cartLookupRepository=cartLookupRepository;
    }

    public Cart createCart(String accountName) throws NoAccountException, CartException {
        Account account = accountService.findAccountByName(accountName);
        if(account==null)throw new NoAccountException(NoAccountException.noAccount);
        if(findActiveCart(accountName)!=null)throw new CartException(CartException.alreadyActive);
        Cart cart = new Cart(true,null, account,null);
        cart = cartRepository.save(cart);
        return cart;
    }
    public List<Cart> findCartsByAccount(String accountName) throws NoAccountException {
        Account account = accountService.findAccountByName(accountName);
        if(account==null)throw new NoAccountException(NoAccountException.noAccount);
        return cartRepository.findByAccount(account);
    }

    public CartWithProductsDto findActiveCart(String accountName) throws NoAccountException {
        Account account = accountService.findAccountByName(accountName);
        if(account==null)throw new NoAccountException(NoAccountException.noAccount);
        Cart cart= cartRepository.findByActiveAndAccount(true,account);
        if(cart==null)return null;
        return new CartWithProductsDto(
                cart, fillCart(cart)
        );

    }
    public CartWithProductsDto editCart(CartLookup cartLookup, String accountName) throws CartException, NoAccountException {
        if(cartLookup.getProduct()==null||cartLookup.getQuantity()<0)throw new CartException(CartException.cartLookupMissingInfo);
        CartWithProductsDto cart = findActiveCart(accountName);
        cartLookup.setCartLookUpId(null);
        //ind is the index of the cartLookup containing the same product to be added, returns -1 if not containing target
        int ind = cartContainsProduct(cart,cartLookup.getProduct());
        if(ind>=0){
            if (cartLookup.getQuantity() > 0) {
                System.out.println("in ind 1+ quantity");
                cart.getProductList().get(ind).setQuantity(cartLookup.getQuantity());
                cartLookupRepository.save(cart.getProductList().get(ind));
            }
            else {
                System.out.println("in ind 0 quantity");
                cartLookupRepository.delete(cart.getProductList().get(ind));
                cart.getProductList().remove(ind);
            }
        }
        else{
            if(cartLookup.getQuantity()>0){
                System.out.println("in else 1+ quantity");
                cartLookup.setCart(cart.getCart());
                CartLookup result = cartLookupRepository.save(cartLookup);
                cart.getProductList().add(result);
            }
            else{
                System.out.println("in else 0 quantity");

            }

        }
        return cart;
    }

//    public CartWithProductsDto removeFromCart(CartLookup cartLookup, String accountName){
//        if(cartLookup.getProduct()==null||cartLookup.getQuantity()<0)throw new CartException(CartException.cartLookupMissingInfo);
//        CartWithProductsDto cart = findActiveCart(accountName);
//        //ind is the index of the cartLookup containing the same product to be added, returns -1 if not containing target
//        int ind = cartContainsProduct(cart,cartLookup.getProduct());
//        if(ind>=0){
//            cart.getProductList().get(ind).setQuantity(cartLookup.getQuantity());
//            cartLookupRepository.save(cart.getProductList().get(ind));
//        }
//        else{
//            cartLookupRepository.save(cartLookup);
//            cart.getProductList().add(cartLookup);
//        }
//        return cart;
//    }

    public int cartContainsProduct(CartWithProductsDto cart, Product product){
        List<CartLookup> list = cart.getProductList();
        for (int i = 0; i<list.size();i++){
            if(list.get(i).getProduct().getProductId()==product.getProductId())return i;
        }
        return -1;
    }
    public List<CartLookup> fillCart(Cart cart){
        return cartLookupRepository.findByCart(cart);
    }
}
