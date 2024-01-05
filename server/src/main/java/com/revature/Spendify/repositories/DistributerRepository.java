package com.revature.Spendify.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Distributer;

@Repository
public interface DistributerRepository extends JpaRepository<Distributer, Integer> {
    Optional<Distributer> findByDistributerId(Long distributorId);
    void deleteByDistributerId(Long distributorId);
    Distributer findByName(String name);
    Distributer findByEmail(String email);
    Distributer findByAccount(Account accountId);
}
    

