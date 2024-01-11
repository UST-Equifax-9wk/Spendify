package com.revature.Spendify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Spendify.DTOs.DistributorAccountDto;
import com.revature.Spendify.DTOs.UserAccountDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.services.AccountService;



@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    
    @PostMapping("/create-account/distributor")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Account> createDistributorAccount(@RequestBody DistributorAccountDto distributorAccountDto){
        //if not request body doesn't match return 417
        if(distributorAccountDto==null)return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        try {
            Account account = accountService.createDistributorAccount(distributorAccountDto);
            return new ResponseEntity<>(account,HttpStatus.OK);
        }
        catch(InvalidInputException e){
            //return 400 for invalid input
            if(e.getMessage().equals(InvalidInputException.invalidInput))return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //return 409 for duplicate of unique attribute
            else if (e.getMessage().equals(InvalidInputException.duplicateUseOfUniqueAttribute))return new ResponseEntity<>(HttpStatus.CONFLICT);
            //return 422 for unknown exception
            else return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/retrieve-account/{username}")
    public ResponseEntity<Account> retrieveAccount(@PathVariable String username){
        try{
            Account account = accountService.retrieveAccount(username);
            return new ResponseEntity<>(account,HttpStatus.OK);
        }
        catch(InvalidInputException e){
            //return 400 for invalid input
            if(e.getMessage().equals(InvalidInputException.invalidInput))return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //return 404 for account not found
            else if (e.getMessage().equals(InvalidInputException.accountNotFound))return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            //return 422 for unknown exception
            else return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    
    
    @PostMapping(path="/create-account/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserAccountDto> createUserAccount(@RequestBody UserAccountDto userAccountDto){
        //if not request body doesn't match return 417
        if(userAccountDto==null)return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        try {
            UserAccountDto account = accountService.createUserAccount(userAccountDto);
            return new ResponseEntity<>(account,HttpStatus.OK);
        }
        catch(InvalidInputException e){
            //return 400 for invalid input
            if(e.getMessage().equals(InvalidInputException.invalidInput))return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            //return 409 for duplicate of unique attribute
            else if (e.getMessage().equals(InvalidInputException.duplicateUseOfUniqueAttribute))return new ResponseEntity<>(HttpStatus.CONFLICT);
            //return 422 for unknown exception
            else return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/user/{accountName}")
    public ResponseEntity<Account> getUserAccount(@PathVariable String accountName){
        //if no accountName return 417
        if(accountName.isEmpty())return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        Account result = accountService.findAccountByName(accountName);
        if(result==null)return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
