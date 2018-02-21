package com.finance.atm.repositories;

import com.finance.atm.entities.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by klim3 on 2/20/2018.
 */
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
    Optional<CustomerAccount> findByPin(int pin);
}
