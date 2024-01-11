package com.revature.Spendify.controllers;

import com.revature.Spendify.entities.Card;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.services.CardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class CardController {
    private CardService cardService;

    @Autowired
    CardController(CardService cardService){
        this.cardService=cardService;
    }

    @PostMapping("/card/{accountName}")
    public ResponseEntity<Card> addCard(@RequestBody Card card, @PathVariable String accountName){
        //if request body doesn't match return 417
        if(card==null||accountName==null)return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

        try {
            Card result = cardService.addCard(card,accountName);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/card/{accountName}")
    public ResponseEntity<List<Card>> getCardsByName(@PathVariable String accountName){
        if(accountName==null)return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        try {
            List<Card> result = cardService.findCardsByAccountName(accountName);
            return new ResponseEntity<>(result,HttpStatus.OK);
        } catch (InvalidInputException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
