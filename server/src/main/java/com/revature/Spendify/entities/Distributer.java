package com.revature.Spendify.entities;

import jakarta.persistence.*;

@Entity(name = "distributers")
public class Distributer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "distributer_id")
    private int distributerId;

    @Column
    private String name;

    @Column
    private String email;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Distributer() {
    }

    public Distributer(String name, String email, Account account) {
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public Distributer(int distributerId, String name, String email, Account account) {
        this.distributerId = distributerId;
        this.name = name;
        this.email = email;
        this.account = account;
    }

    public int getDistributerId() {
        return distributerId;
    }

    public void setDistributerId(int distributerId) {
        this.distributerId = distributerId;
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
