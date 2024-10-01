package com.example.universidadSystem.universidad.model;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "universidad")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String web;
    @Column(nullable = false, unique = true)
    private String codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    private Direccion direccion;

    private String email;

    public Universidad(String nombre, String telefono, String web, String codigo, Direccion direccion, String email) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
        this.codigo = codigo;
        this.direccion = direccion;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Universidad [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", web=" + web + ", codigo="
                + codigo + ", direccionId=" + direccion + ", email: " + email + "]";
    }

    public String getEmail() {
        return this.email;
    }

}
