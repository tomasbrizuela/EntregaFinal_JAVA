package com.example.universidadSystem.universidad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.universidadSystem.universidad.model.Universidad;
import com.example.universidadSystem.universidad.services.UniversidadService;

@SpringBootApplication
public class UniversidadSystemApplication implements CommandLineRunner {

	@Autowired
	UniversidadService universidadService;

	public static void main(String[] args) {
		SpringApplication.run(UniversidadSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola Mundo!...");

		List<Universidad> unis = universidadService.getAllUniversidad();

		for (Universidad uni : unis) {
			System.out.println(uni.getEmail());
		}

		System.out.println("Fin...........");

	}

}
