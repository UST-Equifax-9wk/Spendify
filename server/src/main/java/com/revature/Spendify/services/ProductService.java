package com.revature.Spendify.services;

import com.revature.Spendify.DTOs.BidDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.CartLookup;
import com.revature.Spendify.entities.Product;
import com.revature.Spendify.exceptions.InvalidBidException;
import com.revature.Spendify.repositories.CartLookupRepository;
import com.revature.Spendify.repositories.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Product updateBidOnProduct(String id, BidDto bidDto) throws InvalidBidException {
        Integer productId = Integer.valueOf(id);
        Optional<Product> opt = findProductById(productId);
        Product product = opt.get();
        String bidderUsername = bidDto.getAccountName();
        Account bidderAccount = accountService.findAccountByName(bidderUsername);
        Double bidAmount = bidDto.getBid();
        if(bidderAccount == null) throw new InvalidBidException("User account name does not exist.");
        if(!product.getBiddable()) throw new InvalidBidException("Item is not biddable.");
        if(bidAmount <= product.getCurrentBid()) throw new InvalidBidException("Bid is lower or equal to current bid.");
        product.setCurrentBid(bidAmount);
        product.setCurrentBidder(bidderAccount);
        return createOrUpdateProduct(product);
    }

    public List<Product> productListByCategory(Product.Category category) {
        return productRepository.findByCategory(category);
    }
}
