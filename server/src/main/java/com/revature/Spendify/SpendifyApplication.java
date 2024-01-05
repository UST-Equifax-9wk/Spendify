package com.revature.Spendify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ComponentScan(basePackages = "com.revature.Spendify.controllers, com.revature.Spendify.services, com.revature.Spendify.repositories")
@SpringBootApplication
public class SpendifyApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpendifyApplication.class, args);
	}

}
