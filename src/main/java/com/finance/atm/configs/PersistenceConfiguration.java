package com.finance.atm.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by klim3 on 2/20/2018.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.finance.atm.repositories")
public class PersistenceConfiguration {
}
