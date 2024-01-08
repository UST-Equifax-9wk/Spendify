package com.revature.Spendify.exceptions;

public class InvalidInputException extends Exception{
    public static String invalidInput = "Invalid input";
    public static String duplicateUseOfUniqueAttribute="Unique Constraint Failed";
    public InvalidInputException(String message){
        super(message);
    }
}
