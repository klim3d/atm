package com.finance.atm.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by klim3 on 2/20/2018.
 */
@Entity
@Table(name = "CUSTOMER_ACCOUNT")
public class CustomerAccount {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private int pin;

    @Column
    @JsonProperty("amount")
    private double amount;

    @Column
    private String customerFirstName;

    @Column
    private String customerLastName;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
