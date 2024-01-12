package com.revature.Spendify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Spendify.DTOs.BidDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Product;
import com.revature.Spendify.exceptions.InvalidBidException;
import com.revature.Spendify.services.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/{accountName}/products")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product addProduct(@PathVariable String accountName, @RequestBody Product product) {
        return this.productService.addProductWithAccountName(accountName, product);
    }

    @PostMapping(path = "/products/{productId}/bid")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product updateBidOnProduct(@PathVariable String productId, @RequestBody BidDto bidDto) throws InvalidBidException {
        return this.productService.updateBidOnProduct(productId, bidDto);
    }

    @GetMapping(path = "/products/{productId}/bid")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Account getBidder(@PathVariable String productId) {
        return this.productService.getHighestBidder(productId);
    }

    @PutMapping(path = "/product")
    public Product updateProduct(@RequestBody Product product) {
        return this.productService.createOrUpdateProduct(product);
    }

    // In Progress
    @GetMapping(path = "/{productCategory}/products/productCategory")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Product> productListByCategory(@PathVariable String productCategory) {
        return productService.productListByCategory(Product.Category.valueOf(productCategory));
    }

    @GetMapping(path = "/{productName}/products/productName")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Product> productListByProductName(@PathVariable String productName) {
        return productService.productListByProductName(productName);
    }

    @GetMapping(path = "/{productCategory}/{productName}/products/both")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Product> productListByCategoryAndProductName(@PathVariable String productCategory, @PathVariable String productName) {
        return productService.productListByCategoryAndProductName(productCategory, productName);
    }

    @ExceptionHandler(InvalidBidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptionHandler(InvalidBidException ex) { return ex.getMessage(); }

}
