package com.revature.Spendify.exceptions;

public class CartException extends Exception {
    public static String alreadyActive = "Cannot create a second active cart";
    public static String cartLookupMissingInfo = "Missing information";
    public CartException(String message) {
        super(message);
    }
}