package com.finance.atm.services.exceptions;

/**
 * Created by klim3 on 2/20/2018.
 */
public class CustomerAccountNotEnoughFundsException extends Exception {
    public CustomerAccountNotEnoughFundsException(String message) {
        super(message);
    }
}
