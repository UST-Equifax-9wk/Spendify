package com.revature.Spendify.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.Spendify.DTOs.DistributorAccountDto;
import com.revature.Spendify.entities.Distributor;
import com.revature.Spendify.services.DistributorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class DistributorController {
    private final DistributorService distributorService;

    public DistributorController(DistributorService distributorService) {
        this.distributorService = distributorService;
    }

    @PostMapping("/distributers")
    public ResponseEntity<Distributor> createDistributor(@RequestBody DistributorAccountDto distributorAccountDto) {
        Distributor distributor = distributorAccountDto.getDistributor();
        Distributor createdDistributor = distributorService.createDistributor(distributorAccountDto.getAccountName(), distributorAccountDto.getPassword(), distributor);
        return ResponseEntity.ok(createdDistributor);
    }

    @PutMapping("/distributers/{id}")
    public ResponseEntity<Distributor> updateDistributer(@PathVariable("id") Long id, @RequestBody Distributor distributor) {
        Distributor updatedDistributor = distributorService.updateDistributer(id, distributor);
        return ResponseEntity.ok(updatedDistributor);
    }

    @DeleteMapping("/distributers/{id}")
    public ResponseEntity<Void> deleteDistributor(@PathVariable("id") Long id) {
        distributorService.deleteDistributor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/distributers/{id}")
    public ResponseEntity<Distributor> getDistributorById(@PathVariable("id") Long id) {
        Distributor distributer = distributorService.getDistributorById(id);
        return ResponseEntity.ok(distributer);
    }
}


    

    