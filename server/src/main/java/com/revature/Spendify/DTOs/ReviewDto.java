package com.revature.Spendify.DTOs;

public class ReviewDto {
    private String text;
    private Integer rating;
    private String accountName;

    public ReviewDto(String text, Integer rating, String accountName) {
        this.text = text;
        this.rating = rating;
        this.accountName = accountName;
    }

    public ReviewDto() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
