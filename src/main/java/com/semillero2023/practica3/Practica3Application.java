package com.semillero2023.practica3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EntityScan("com.semillero2023.mi_libreria")
public class Practica3Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica3Application.class, args);
	}

}
