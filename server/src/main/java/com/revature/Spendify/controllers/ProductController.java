package com.revature.Spendify.controllers;

import com.revature.Spendify.entities.Product;
import com.revature.Spendify.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // In Progress
    @GetMapping(path = "/{productCategory}/products")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Product> productListByCategory(@PathVariable String productCategory) {
        return productService.productListByCategory(Product.Category.valueOf(productCategory));
    }
}
