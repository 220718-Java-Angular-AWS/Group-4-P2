package com.revature.Group4P2;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Group4P2Application {

	public static void main(String[] args) {

		SpringApplication.run(Group4P2Application.class, args);
		System.out.println("random");
		Configuration config = new Configuration();
	}



}
