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

import com.revature.Spendify.entities.Distributer;
import com.revature.Spendify.services.DistributerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class DistributerController {
    private final DistributerService distributorService;

    public DistributerController(DistributerService distributorService) {
        this.distributorService = distributorService;
    }

    @PostMapping("/distributers")
    public ResponseEntity<Distributer> createDistributer(@RequestBody Distributer distributer) {
        Distributer createdDistributer = distributorService.createDistributer(distributer);
        return ResponseEntity.ok(createdDistributer);
    }

    @PutMapping("/distributers/{id}")
    public ResponseEntity<Distributer> updateDistributer(@PathVariable("id") Long id, @RequestBody Distributer distributer) {
        Distributer updatedDistributer = distributorService.updateDistributer(id, distributer);
        return ResponseEntity.ok(updatedDistributer);
    }

    @DeleteMapping("/distributers/{id}")
    public ResponseEntity<Void> deleteDistributer(@PathVariable("id") Long id) {
        distributorService.deleteDistributer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/distributers/{id}")
    public ResponseEntity<Distributer> getDistributerById(@PathVariable("id") Long id) {
        Distributer distributer = distributorService.getDistributerById(id);
        return ResponseEntity.ok(distributer);
    }
}


    

    