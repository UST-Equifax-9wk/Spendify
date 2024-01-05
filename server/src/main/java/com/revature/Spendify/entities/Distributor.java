package com.revature.Spendify.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "distributors")
public class Distributor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "distributor_id")
    private int distributorId;

    @Column
    private String name;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributerId) {
        this.distributorId = distributerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
