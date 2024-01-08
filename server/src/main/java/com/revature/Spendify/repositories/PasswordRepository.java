package com.revature.Spendify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Spendify.entities.Password;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {
    
}
