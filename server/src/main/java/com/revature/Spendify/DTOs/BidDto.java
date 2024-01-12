package com.revature.Spendify.DTOs;

public class BidDto {
    private String accountName;
    private Double bid;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public BidDto() {
    }

    public BidDto(String accountName, Double bid) {
        this.accountName = accountName;
        this.bid = bid;
    }
}
