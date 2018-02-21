package com.finance.atm;

import com.finance.atm.controllers.CustomerAccountController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmApplicationTests {

	@Autowired
	private CustomerAccountController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
