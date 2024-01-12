package com.revature.Spendify.controllers;

import com.revature.Spendify.DTOs.BidDto;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/product")
    public Product updateProduct(@RequestBody Product product) {
        return this.productService.createOrUpdateProduct(product);
    }

    // In Progress
    @GetMapping(path = "/{productCategory}/products")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Product> productListByCategory(@PathVariable String productCategory) {
        return productService.productListByCategory(Product.Category.valueOf(productCategory));
    }

    @ExceptionHandler(InvalidBidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exceptionHandler(InvalidBidException ex) { return ex.getMessage(); }

}
