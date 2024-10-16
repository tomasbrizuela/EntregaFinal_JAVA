package com.example.universidadSystem.universidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.universidadSystem.universidad.model.Universidad;

@Repository
public interface UniversidadRepository extends JpaRepository<Universidad, Long> {

};
