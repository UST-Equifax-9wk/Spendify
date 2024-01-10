package com.revature.Spendify.repositories;

import com.revature.Spendify.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);

    @Query(value = "SELECT * FROM users where account_id = ?1", nativeQuery = true)
    public User findByAccountId(Integer id);
}
