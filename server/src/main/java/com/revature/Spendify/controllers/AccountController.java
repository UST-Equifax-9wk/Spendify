package com.revature.Spendify.controllers;

import com.revature.Spendify.DTOs.UserAccountDto;
import com.revature.Spendify.entities.Account;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping(path="/create-account/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserAccountDto> createUserAccount(@RequestBody UserAccountDto userAccountDto){
        System.out.println("Bark");
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
}
