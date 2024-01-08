package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password,String> {
}
