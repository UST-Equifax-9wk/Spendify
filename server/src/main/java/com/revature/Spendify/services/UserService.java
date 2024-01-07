package com.revature.Spendify.services;

import com.revature.Spendify.entities.User;
import com.revature.Spendify.exceptions.InvalidInputException;
import com.revature.Spendify.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class UserService {
    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User createUser(User user) throws InvalidInputException {
        if(user==null||
                user.getFirstName()==null||
                user.getLastName()==null||
                user.getAddress()==null||
                user.getEmail()==null||
                user.getAccount()==null||
                checkEmail(user.getEmail())
        ) throw new InvalidInputException(InvalidInputException.invalidInput);
        if(userRepository.findByEmail(user.getEmail())!=null)throw new InvalidInputException(InvalidInputException.duplicateUseOfUniqueAttribute);
        userRepository.save(user);
        return user;
    }

    //TODO add email checking requirements
    public boolean checkEmail(String email){
        return true;
    }
}
