package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "account_id")
    @JsonBackReference("distributor")
    private Account account;


    public Distributor() {
    }

    public Distributor(String name, String email, Account account) {
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public Distributor(int distributorId, String name, String email, Account account) {
        this.distributorId = distributorId;
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public int getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(int distributorId) {
        this.distributorId = distributorId;
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
