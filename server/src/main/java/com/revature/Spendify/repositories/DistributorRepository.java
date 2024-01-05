package com.revature.Spendify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {
    Distributor findByDistributorId(Long distributorId);
    Distributor findByName(String name);
    Distributor findByEmail(String email);
    Distributor findByAccountId(Long accountId);
}
    

