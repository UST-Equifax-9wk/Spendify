package com.revature.Spendify.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.Spendify.entities.Account;
import com.revature.Spendify.entities.Distributor;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
    Optional<Distributor> findByDistributorId(Long distributorId);
    void deleteByDistributorId(Long distributorId);
    Distributor findByName(String name);
    Distributor findByEmail(String email);
    Distributor findByAccount(Account accountId);
}
    

