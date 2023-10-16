package com.budy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudyApplication.class, args);
	}

}
