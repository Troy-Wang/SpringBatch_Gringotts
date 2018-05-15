package com.troywang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.troywang")
public class GringottsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GringottsApplication.class, args);
	}
}
