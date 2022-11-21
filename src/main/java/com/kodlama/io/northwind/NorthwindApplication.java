package com.kodlama.io.northwind;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}
	
	// model mapper üstünde anostasyon olmadığı için burada new oluşturuyoruz. Biri isterse kullansın.
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
