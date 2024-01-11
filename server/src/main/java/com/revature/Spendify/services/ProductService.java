package com.revature.Spendify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Product;
import com.revature.Spendify.repositories.CartLookupRepository;
import com.revature.Spendify.repositories.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class ProductService {
    private final ProductRepository productRepository;
    private final AccountService accountService;
    private final CartLookupRepository cartLookupRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, AccountService accountService, CartLookupRepository cartLookupRepository) {
        this.productRepository = productRepository;
        this.accountService = accountService;
        this.cartLookupRepository = cartLookupRepository;
    }

    public Product createOrUpdateProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
        if (optionalProduct.isPresent()) {
            Product oldProduct = optionalProduct.get();
            oldProduct.setPrice(product.getPrice());
            oldProduct.setStock(product.getStock());
            return this.productRepository.save(oldProduct);
        }
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

    public Product addProductWithAccountName(String accountName, Product product) {
        Account account = accountService.findAccountByName(accountName);
        product.setAccount(account);
        return createOrUpdateProduct(product);
    }

    public List<Product> productListByCategory(Product.Category category) {
        return productRepository.findByCategory(category);
    }
}
