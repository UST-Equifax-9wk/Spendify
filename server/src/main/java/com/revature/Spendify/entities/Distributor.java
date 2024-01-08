package com.revature.Spendify.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity(name = "distributors")
public class Distributor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "distributor_id")
    private int distributorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "account_id")
    @JsonManagedReference("distributor")
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
