package com.revature.Spendify.controllers;

import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Password;
import com.revature.Spendify.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private AccountService accountService;
    @Autowired
    AuthController(AuthenticationManager authenticationManager, AccountService accountService){
        this.authenticationManager=authenticationManager;
        this.accountService=accountService;
    }
    @PostMapping("/login")
    public ResponseEntity<Account> customLogin(@RequestBody Password password) {
        System.out.println("Firstin endpoint");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(password.getAccountName(), password.getPassword())
        );
        System.out.println("After authentication before contextholder");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Account account = accountService.findAccountByName(password.getAccountName());
        System.out.println("Account: "+account.toString());
        System.out.println("Before if statement");
        if(authentication.getName()!=null){
            System.out.println("In if");
            return new ResponseEntity<>(account, HttpStatus.ACCEPTED);
        }
        else{
            System.out.println("In else");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //Exception
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleAuthFail(EntityNotFoundException ex) {
        return ex.getMessage();
    }

}