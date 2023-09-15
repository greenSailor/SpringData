package com.personal.SpringData;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}
// By SpringDataApplication implements CommandLineRunner the data can be stored to my sql using the transactional statements
// or the same thing can be done by creating a Junit Test for the Product Repository and run the code to store data.
//		implements CommandLineRunner {
//	@Override
//	public void run(String... args) throws Exception {
//
//	}
}
