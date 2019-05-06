package com.vendingmachine.payment;

/**
 * This class calls payment services to check whether new payment was made or not, cancel payment,
 * work with external payment systems
 */
public class Payment {

    public static final String RESPONSE_OK = "OK";
    public static final String RESPONSE_NOT_ENOUGH_MONEY = "response_not_enough_money";
    public static final String RESPONSE_UNIDENTIFIED_ERROR = "unexpected_error";

    /**
     * Checks that new payment was commited
     * @param token
     * @param productId
     * @return status message
     */
    public static String checkNewPayment(long token, String productId) {
        //some logic for checking new payment
        //mark new payment as checked

        //call external service

        //simulated responses: "OK"; "NOT ENOUGH MONEY; "UNIDENTIFIED ERROR"

        return RESPONSE_OK;
    }

    /**
     * Cancels new payment.
     * Use cases: product out of stock or ingredients(water/cups), something not working, moneyback, etc
     * @param token
     * @param productId
     */
    public static void cancelNewPayment(long token, String productId) {
        //some logic
        //return RESPONSE_OK ...
    }
}
