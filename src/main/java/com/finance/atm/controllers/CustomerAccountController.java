package com.finance.atm.controllers;

import com.finance.atm.entities.CustomerAccount;
import com.finance.atm.services.CustomerAccountService;
import com.finance.atm.services.exceptions.CustomerAccountNotEnoughFundsException;
import com.finance.atm.services.exceptions.CustomerAccountNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by klim3 on 2/20/2018.
 */
@Controller
public class CustomerAccountController {

    private static Logger LOGGER = LoggerFactory.getLogger(CustomerAccountController.class);

    @Autowired
    private CustomerAccountService customerAccountService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/account/{pin}")
    public ResponseEntity<CustomerAccount> getAccount(@PathVariable("pin") int pin) {
        CustomerAccount customerAccount;
        try {
            customerAccount = customerAccountService.getCustomerAccount(pin);
        } catch (CustomerAccountNotFoundException e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customerAccount);
    }

    @PutMapping("/account/{pin}")
    public ResponseEntity<CustomerAccount> updateAccount(@PathVariable("pin") int pin, @RequestParam("delta") Integer delta) {
        if (delta == null || delta == 0) {
            LOGGER.error("Incorrect amount requested.");
            return ResponseEntity.badRequest().build();
        }
        CustomerAccount customerAccount;
        try {
            customerAccount = customerAccountService.updateCustomerAccount(pin, delta);
        } catch (CustomerAccountNotFoundException | CustomerAccountNotEnoughFundsException e) {
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customerAccount);
    }
}
