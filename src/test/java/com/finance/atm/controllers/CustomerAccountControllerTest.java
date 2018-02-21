package com.finance.atm.controllers;


import com.finance.atm.entities.CustomerAccount;
import com.finance.atm.services.CustomerAccountService;
import com.finance.atm.services.exceptions.CustomerAccountNotEnoughFundsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by klim3 on 2/21/2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerAccountController.class)
public class CustomerAccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerAccountService service;

    @Test
    public void getAccount() throws Exception {
        CustomerAccount account = new CustomerAccount();
        double amount = 50;
        int pin = 1212;

        account.setAmount(amount);
        given(service.getCustomerAccount(pin)).willReturn(account);

        mvc.perform(get("/account/" + pin)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("amount", is(amount)));
    }

    @Test
    public void updateAccount() throws Exception {
        CustomerAccount account = new CustomerAccount();
        double amount = 50;
        int delta = -30;
        int pin = 1212;

        account.setAmount(amount + delta);
        account.setPin(pin);
        given(service.updateCustomerAccount(pin, delta)).willReturn(account);

        mvc.perform(put("/account/" + pin + "?delta=" + delta)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("amount", is(amount + delta)));
    }

}