package com.example.demo;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class SpringBootSecondProjectWithAngular7Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecondProjectWithAngular7Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper modelmapper =new ModelMapper();
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelmapper;
	}
}
