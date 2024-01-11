package com.revature.Spendify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Spendify.entities.Product;
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
}
