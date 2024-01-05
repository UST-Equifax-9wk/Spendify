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
    public DistributorService(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
    }


    public Distributor createDistributer(Distributor distributor) {
        return distributorRepository.save(distributor);
    }

    public Distributor updateDistributer(Long id, Distributor distributor) {
        Distributor existingDistributer = distributorRepository.findByDistributorId(id).orElse(null);
        if (existingDistributer != null) {
            existingDistributer.setName(distributor.getName());
            existingDistributer.setEmail(distributor.getEmail());
            return distributorRepository.save(existingDistributer);
        }
        return null;
    }

    public Distributor getDistributorById(Long id) {
        return distributorRepository.findByDistributorId(id).orElse(null);
    }


    public void deleteDistributor(Long id) {
        distributorRepository.deleteByDistributorId(id);
    }


}
