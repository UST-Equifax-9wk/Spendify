package com.revature.Spendify.DTOs;

import com.revature.Spendify.entities.Distributor;

public class DistributorAccountDto {

    private String accountName;
    private String password;
    private Distributor distributor;

    public DistributorAccountDto() {
    }

    public DistributorAccountDto(String password, String accountName, Distributor distributor) {
        this.password = password;
        this.accountName = accountName;
        this.distributor = distributor;
    }

    public String getPassword() {
        return password;
    }
    
    public String getAccountName() {
        return accountName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }
}

    
    

