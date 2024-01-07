package com.revature.Spendify.services;

import com.revature.Spendify.DTOs.UserAccountDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Password;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.repositories.AccountRepository;
import com.revature.Spendify.repositories.PasswordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class AccountService {
    private PasswordRepository passwordRepository;
    private AccountRepository accountRepository;
    private UserService userService;

    @Autowired
    AccountService(PasswordRepository passwordRepository, AccountRepository accountRepository, UserService userService){
        this.accountRepository=accountRepository;
        this.passwordRepository=passwordRepository;
        this.userService=userService;
    }

    public Account createUserAccount(UserAccountDto userAccountDto) throws InvalidInputException {
        if(userAccountDto.getAccountName()==null ||
                userAccountDto.getAccountName().length()<4||
                userAccountDto.getUser()==null||
                userAccountDto.getPassword()==null||
                userAccountDto.getPassword().length()<8
        )throw new InvalidInputException(InvalidInputException.invalidInput);
        if(findAccountByName(userAccountDto.getAccountName())!=null) throw new InvalidInputException(InvalidInputException.duplicateUseOfUniqueAttribute);

        Account account = new Account(userAccountDto.getAccountName(), false, userAccountDto.getUser(), null, null, null);
        Password password = new Password(userAccountDto.getAccountName(),userAccountDto.getPassword());
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
