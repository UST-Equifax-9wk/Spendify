package com.revature.Spendify.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Spendify.services.DistributorService;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class DistributorController {
    private final DistributorService distributorService;

    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    // Other methods for handling distributor requests

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Implement login logic here
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        // Implement register logic here
    }

    @GetMapping("path")
    public SomeData getMethodName(@RequestParam String param) {
        return new SomeData();
    }

}
    

    
}
