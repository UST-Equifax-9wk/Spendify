package com.revature.Spendify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Spendify.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountId(Long accountId);
    void deleteByAccountId(Long accountId);
    Account findByAccountName(String accountName);
    
}
