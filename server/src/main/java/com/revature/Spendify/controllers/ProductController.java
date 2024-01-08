package com.revature.Spendify.controllers;

import com.revature.Spendify.entities.Product;
import com.revature.Spendify.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public Product addProduct(@PathVariable String accountName, @RequestBody Product product) {
        //TODO: tie product with account
        return this.productService.createOrUpdateProduct(product);
    }
}
