package com.usa.computadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.usa.computadores.model"})  // scan JPA entities
@SpringBootApplication
public class ComputadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputadoresApplication.class, args);
	}

}
