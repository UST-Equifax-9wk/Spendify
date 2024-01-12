package com.revature.Spendify.services;

import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Password;
import com.revature.Spendify.repositories.AccountRepository;
import com.revature.Spendify.repositories.PasswordRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuthService implements UserDetailsService {

    private PasswordRepository passwordRepository;

    private AccountRepository accountRepository;
    @Autowired
    private UserAuthService (PasswordRepository userRepository,
                             AccountRepository accountRepository){
        this.passwordRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Password password = passwordRepository.findByAccountName(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + username));

        Account account = accountRepository.findByAccountName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (account.isDistributorFlag()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_DISTRIBUTOR"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new User(password.getAccountName(), password.getPassword(), authorities);
    }

}
