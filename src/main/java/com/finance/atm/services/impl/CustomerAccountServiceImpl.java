package com.finance.atm.services.impl;

import com.finance.atm.entities.CustomerAccount;
import com.finance.atm.repositories.CustomerAccountRepository;
import com.finance.atm.services.CustomerAccountService;
import com.finance.atm.services.exceptions.CustomerAccountNotEnoughFundsException;
import com.finance.atm.services.exceptions.CustomerAccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by klim3 on 2/20/2018.
 */
@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

    @Autowired
    private CustomerAccountRepository customerAccountRepository;

    @Override
    public CustomerAccount getCustomerAccount(int pin) {
        return customerAccountRepository.findByPin(pin).orElseThrow(() ->
                new CustomerAccountNotFoundException("Customer account wasn't found."));
    }

    @Override
    public CustomerAccount updateCustomerAccount(int pin, int delta) throws CustomerAccountNotEnoughFundsException {
        CustomerAccount customerAccount = customerAccountRepository.findByPin(pin).orElseThrow(() ->
                new CustomerAccountNotFoundException("Customer account wasn't found."));

        double currentAmount = customerAccount.getAmount();
        if (currentAmount <= 0 && delta < 0 || (currentAmount + delta < 0)) {
            throw new CustomerAccountNotEnoughFundsException("Not enough funds.");
        }
        customerAccount.setAmount(currentAmount + delta);
        return customerAccountRepository.save(customerAccount);
    }
}
