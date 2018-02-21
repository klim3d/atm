package com.finance.atm.services;

import com.finance.atm.entities.CustomerAccount;
import com.finance.atm.services.exceptions.CustomerAccountNotEnoughFundsException;

/**
 * Created by klim3 on 2/20/2018.
 */
public interface CustomerAccountService {
    CustomerAccount getCustomerAccount(int pin);

    CustomerAccount updateCustomerAccount(int pin, int delta) throws CustomerAccountNotEnoughFundsException;
}
