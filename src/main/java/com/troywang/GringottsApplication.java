package com.troywang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.troywang")
@MapperScan("com.troywang.dal.mapper")
public class GringottsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GringottsApplication.class, args);
	}
}
