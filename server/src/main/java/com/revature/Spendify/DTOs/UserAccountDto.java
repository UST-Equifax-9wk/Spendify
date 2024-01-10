package com.revature.Spendify.DTOs;

import com.revature.Spendify.entities.User;

public class UserAccountDto {
    private User user;
    private String accountName;
    private String password;

    public UserAccountDto() {
    }

    public UserAccountDto(User user, String accountName, String password) {
        this.user = user;
        this.accountName = accountName;
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
