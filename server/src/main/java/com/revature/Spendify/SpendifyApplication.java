package com.revature.Spendify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpendifyApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpendifyApplication.class, args);
	}

}
