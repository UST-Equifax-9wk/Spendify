package com.revature.Spendify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.Spendify.DTOs.DistributorAccountDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.repositories.AccountRepository;
import com.revature.Spendify.repositories.DistributorRepository;
import com.revature.Spendify.repositories.PasswordRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class AccountService {
    private PasswordRepository passwordRepository;
    private AccountRepository accountRepository;
    private DistributorRepository distributorRepository;
    
    @Autowired
    public AccountService(PasswordRepository passwordRepository, AccountRepository accountRepository, DistributorRepository distributorRepository) {
        this.passwordRepository = passwordRepository;
        this.accountRepository = accountRepository;
        this.distributorRepository = distributorRepository;
    }

    public Account createdDistributorAccount(DistributorAccountDto distributorAccountDto) {
        if()
    }
}
