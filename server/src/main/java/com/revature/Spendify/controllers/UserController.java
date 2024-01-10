package com.revature.Spendify.controllers;

import com.revature.Spendify.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService=userService;
    }

}
