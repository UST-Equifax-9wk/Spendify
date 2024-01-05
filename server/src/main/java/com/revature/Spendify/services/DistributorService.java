package com.revature.Spendify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Spendify.entities.Distributor;
import com.revature.Spendify.repositories.DistributorRepository;


@Service
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public class DistributorService {

    private final DistributorRepository distributorRepository;


    @Autowired
    public DistributorServiceImpl(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }

    @Override
    public Distributor createDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    @Override
    public Distributor updateDistributor(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    @Override
    public Distributor getDistributorById(int id) {
        return distributorRepository.findById(id).orElse(null);
    }

    // Other methods for querying distributors

}
