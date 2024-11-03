package com.example.universidadSystem.universidad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversidadSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversidadSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola Mundo!...");

	}

}
