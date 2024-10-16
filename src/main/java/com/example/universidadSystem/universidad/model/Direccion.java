package com.example.universidadSystem.universidad.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "direccion")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter

public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String altura;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ciudad ciudad;

    @OneToOne(mappedBy = "direccion_id")
    @JsonBackReference
    private Universidad universidad;

    public Direccion(String calle, String altura, Ciudad ciudad) {
        this.calle = calle;
        this.altura = altura;
        this.ciudad = ciudad;
    };

}
