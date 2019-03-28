package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSecondProjectWithAngular7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecondProjectWithAngular7Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		
		return new ModelMapper();
	}
}
