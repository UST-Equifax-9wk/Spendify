package com.revature.Spendify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.Spendify.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountId(Long accountId);
    Account findByEmail(String email);
    void deleteByAccountId(Long accountId);
    
}
