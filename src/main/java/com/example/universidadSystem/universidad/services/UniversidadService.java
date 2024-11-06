package com.example.universidadSystem.universidad.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.universidadSystem.universidad.DTO.UniversidadDTO;
import com.example.universidadSystem.universidad.model.Universidad;
import com.example.universidadSystem.universidad.repository.UniversidadRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UniversidadService {
    @Autowired
    static UniversidadRepository universidadRepository;

    public UniversidadService(UniversidadRepository universidadRepository) {
        UniversidadService.universidadRepository = universidadRepository;
    }

    public ArrayList<Universidad> getAllUniversidad() {
        return (ArrayList<Universidad>) universidadRepository.findAll();
    };

    public void createUniversidad(Universidad universidad) {
        universidadRepository.save(universidad);
    }

    public Universidad obtenerPorId(Long id) {
        return universidadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Error"));
    }

    public String actualizarUni(Long id, Universidad universidad) {
        Universidad universidadNueva = universidadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("error, no id finded!"));

        if (universidad.getNombre() != null) {
            System.out.println("..............." + universidad.getNombre());
            universidadNueva.setNombre(universidad.getNombre());
        } else {
            System.out.println("........................EMPTY EMP WERWE");
            universidadNueva.setNombre(universidadNueva.getNombre());
        }

        if (universidad.getEmail() != null) {
            universidadNueva.setEmail(universidad.getEmail());
        } else {
            universidadNueva.setEmail(universidadNueva.getEmail());
        }

        if (universidad.getTelefono() != null) {
            universidadNueva.setTelefono(universidad.getTelefono());
        } else {
            universidadNueva.setTelefono(universidadNueva.getTelefono());
        }

        if (universidad.getCodigo() != null) {
            universidadNueva.setCodigo(universidad.getCodigo());
        } else {
            universidadNueva.setCodigo(universidadNueva.getCodigo());
        }

        if (universidad.getWeb() != null) {
            universidadNueva.setWeb(universidad.getWeb());
        } else {
            universidadNueva.setWeb(universidadNueva.getWeb());
        }

        universidadRepository.save(universidadNueva);

        return universidadNueva.toString();

    }

    public Optional<Universidad> getUsingId(Long id) {
        return universidadRepository.findById(id);
    }

    public void deleteUni(Long id) {
        universidadRepository.deleteById(id);
    }

    public List<UniversidadDTO> getContactInfo() {
        try {
            List<Universidad> unis = universidadRepository.findAll();
            return unis.stream()
                    .map(uni -> new UniversidadDTO(uni.getNombre(), uni.getWeb(), uni.getEmail(), uni.getTelefono()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
