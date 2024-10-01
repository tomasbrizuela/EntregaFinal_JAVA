package com.example.universidadSystem.universidad.model;

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
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "direccion")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

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

    @OneToOne(mappedBy = "direccion")
    private Universidad universidad;

    public Direccion(String calle, String altura, Ciudad ciudad) {
        this.calle = calle;
        this.altura = altura;
        this.ciudad = ciudad;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

}
