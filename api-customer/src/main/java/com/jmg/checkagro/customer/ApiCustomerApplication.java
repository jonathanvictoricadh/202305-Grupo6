package com.jmg.checkagro.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
@EnableMongoRepositories
@EnableFeignClients
public class ApiCustomerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiCustomerApplication.class, args);
	}


}
