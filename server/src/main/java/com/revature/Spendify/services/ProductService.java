package com.revature.Spendify.services;

import com.revature.Spendify.entities.Product;
import com.revature.Spendify.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createOrUpdateProduct(Product product) {
        return this.productRepository.save(product);
    }

    public Optional<Product> findProductById(Integer id) {
        return this.productRepository.findById(id);
    }

    public Optional<Product> removeProductById(Integer id) {
        Optional<Product> product = findProductById(id);
        this.productRepository.deleteById(id);
        return product;
    }
}
