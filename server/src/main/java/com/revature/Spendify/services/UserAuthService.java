package com.revature.Spendify.services;

import com.revature.Spendify.entities.Password;
import com.revature.Spendify.repositories.PasswordRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserAuthService implements UserDetailsService {

    private PasswordRepository passwordRepository;
    @Autowired
    private UserAuthService (PasswordRepository userRepository){
        this.passwordRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Password password = passwordRepository.findByAccountName(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + username));
        return new User(
                password.getAccountName(),
                password.getPassword(),
                new ArrayList<>()
        );
    }

}
