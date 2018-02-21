package com.finance.atm.services.exceptions;

/**
 * Created by klim3 on 2/20/2018.
 */
public class CustomerAccountNotFoundException extends RuntimeException {
    public CustomerAccountNotFoundException(String message) {
        super(message);
    }
}
