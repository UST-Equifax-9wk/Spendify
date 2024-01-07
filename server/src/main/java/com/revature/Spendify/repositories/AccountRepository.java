package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    public Account findByAccountName(String accountName);
}
