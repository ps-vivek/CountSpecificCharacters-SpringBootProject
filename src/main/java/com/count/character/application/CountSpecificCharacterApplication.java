package com.count.character.application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.count.character.*"})
public class CountSpecificCharacterApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CountSpecificCharacterApplication.class, args);
	}
}
