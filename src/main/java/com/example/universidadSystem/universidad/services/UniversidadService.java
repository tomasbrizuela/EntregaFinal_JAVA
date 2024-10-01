package com.example.universidadSystem.universidad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universidadSystem.universidad.model.Universidad;
import com.example.universidadSystem.universidad.repository.UniversidadRepository;

@Service
public class UniversidadService {
    @Autowired
    static UniversidadRepository universidadRepository;

    public UniversidadService(UniversidadRepository universidadRepository) {
        UniversidadService.universidadRepository = universidadRepository;
    }

    public List<Universidad> getAllUniversidad() {
        return universidadRepository.findAll();
    }

}
