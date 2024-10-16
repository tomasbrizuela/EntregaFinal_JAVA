package com.example.universidadSystem.universidad.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Column;

@Entity
@Table(name = "universidad")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter

public class Universidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "web")
    private String web;

    @Column(name = "codigo")
    private String codigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion", referencedColumnName = "id")
    @JsonBackReference
    private Direccion direccion_id;

    @Column(name = "email")
    private String email;

    public Universidad(String nombre, String telefono, String web, String codigo, Direccion direccion_id,
            String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
        this.codigo = codigo;
        this.direccion_id = direccion_id;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Universidad [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", web=" + web + ", codigo="
                + codigo + ", direccionId=" + direccion_id + ", email: " + email + "]";
    }

}
