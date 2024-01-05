package com.revature.Spendify.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.Spendify.entities.Distributer;
import com.revature.Spendify.repositories.DistributerRepository;


@Service
@Transactional(isolation = Isolation.READ_COMMITTED, readOnly = true)
public class DistributerService {

    private final DistributerRepository distributerRepository;


    @Autowired
    public DistributerService(DistributerRepository distributerRepository) {
        this.distributerRepository = distributerRepository;
    }


    public Distributer createDistributer(Distributer distributer) {
        return distributerRepository.save(distributer);
    }

    public Distributer updateDistributer(Long id, Distributer distributer) {
        return distributerRepository.save(distributer);
    }

    public Distributer getDistributerById(Long id) {
        return distributerRepository.findByDistributerId(id).orElse(null);
    }


    public void deleteDistributer(Long id) {
        distributerRepository.deleteByDistributerId(id);
    }

    // Other methods for querying distributors

}
