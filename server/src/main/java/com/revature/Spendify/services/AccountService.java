package com.revature.Spendify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revature.Spendify.DTOs.DistributorAccountDto;
import com.revature.Spendify.DTOs.UserAccountDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Password;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.repositories.AccountRepository;
import com.revature.Spendify.repositories.PasswordRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class AccountService {
    private PasswordRepository passwordRepository;
    private AccountRepository accountRepository;
    private DistributorService distributorService;
    private PasswordEncoder passwordEncoder;
    private UserService userService;
    

    @Autowired
    AccountService(PasswordRepository passwordRepository, AccountRepository accountRepository, UserService userService, DistributorService distributorService, PasswordEncoder passwordEncoder){
        this.accountRepository=accountRepository;
        this.passwordRepository=passwordRepository;
        this.userService=userService;
        this.distributorService=distributorService;
        this.passwordEncoder = passwordEncoder;
    }


    public Account createDistributorAccount(DistributorAccountDto distributorAccountDto) throws InvalidInputException {
        if(distributorAccountDto.getAccountName()==null ||
                distributorAccountDto.getAccountName().length()<4||
                distributorAccountDto.getDistributor()==null||
                distributorAccountDto.getPassword()==null||
                distributorAccountDto.getPassword().length()<8
        )throw new InvalidInputException(InvalidInputException.invalidInput);
        if(findAccountByName(distributorAccountDto.getAccountName())!=null) throw new InvalidInputException(InvalidInputException.duplicateUseOfUniqueAttribute);

        Account account = new Account(distributorAccountDto.getAccountName(), true, null, distributorAccountDto.getDistributor(), null, null,null);
        Password password = new Password(distributorAccountDto.getAccountName(),distributorAccountDto.getPassword());
        distributorAccountDto.getDistributor().setAccount(account);
        this.distributorService.createDistributer(distributorAccountDto.getDistributor());
        this.accountRepository.save(account);
        this.passwordRepository.save(password);
        return account;
    }

    public Account createUserAccount(UserAccountDto userAccountDto) throws InvalidInputException {
        if(userAccountDto.getAccountName()==null ||
                userAccountDto.getAccountName().length()<4||
                userAccountDto.getUser()==null||
                userAccountDto.getPassword()==null||
                userAccountDto.getPassword().length()<8
        )throw new InvalidInputException(InvalidInputException.invalidInput);
        if(findAccountByName(userAccountDto.getAccountName())!=null) throw new InvalidInputException(InvalidInputException.duplicateUseOfUniqueAttribute);

        Account account = new Account(userAccountDto.getAccountName(), false, userAccountDto.getUser(), null, null, null,null);
        Password password = new Password(userAccountDto.getAccountName(),passwordEncoder.encode(userAccountDto.getPassword()));
        userAccountDto.getUser().setAccount(account);
        this.userService.createUser(userAccountDto.getUser());
        this.accountRepository.save(account);
        this.passwordRepository.save(password);
        return account;
    }

    public Account findAccountByName(String name){
        if(name==null)return null;
        return this.accountRepository.findByAccountName(name);
    }
}
