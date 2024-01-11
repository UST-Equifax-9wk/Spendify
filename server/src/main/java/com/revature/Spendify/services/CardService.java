package com.revature.Spendify.services;

import com.revature.Spendify.entities.Card;
import com.revature.Spendify.entities.User;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.repositories.CardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class CardService {
    private CardRepository cardRepository;
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public CardService(CardRepository cardRepository, UserService userService, AccountService accountService){
        this.cardRepository=cardRepository;
        this.userService=userService;
        this.accountService=accountService;
    }

    public Card addCard(Card card, String accountName) throws InvalidInputException {
        if(card==null||
            card.getCardNumber()==null||
                card.getCardNumber().isEmpty()||
                card.getName()==null||card.getName().isEmpty()||
                card.getExpirationDate()==null||
                card.getUser()==null
        )throw new InvalidInputException(InvalidInputException.invalidInput);
        User user = userService.findUserByAccountName(accountName);
        card.setUser(user);
        return cardRepository.save(card);
    }

    public List<Card> findCardsByAccountName(String accountName) throws InvalidInputException {
        if(accountName==null)return null;
        User user = accountService.findAccountByName(accountName).getUser();
        if(user==null)throw new InvalidInputException(InvalidInputException.invalidInput);
        return findCardsByUser(user);
    }

    public List<Card> findCardsByUser(User user) throws InvalidInputException {
        if(user==null) throw new InvalidInputException(InvalidInputException.invalidInput);
        return cardRepository.findByUser(user);
    }
}
