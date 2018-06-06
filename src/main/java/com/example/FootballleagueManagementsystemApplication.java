package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.example.mapper")
@SpringBootApplication
public class FootballleagueManagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballleagueManagementsystemApplication.class, args);
	}
}
