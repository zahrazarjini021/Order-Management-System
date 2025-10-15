package com.example.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.hibernate.entity")
public class HibernateSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateSystemApplication.class, args);
		System.out.println("344444444444444444444444444444444444");

	}

}
