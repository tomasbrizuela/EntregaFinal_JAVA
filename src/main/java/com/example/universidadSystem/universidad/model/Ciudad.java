package com.example.universidadSystem.universidad.model;

public enum Ciudad {
    BUENOS_AIRES(1),
    CAPITAL_FEDERAL(2),
    RIO_NEGRO(3),
    CORDOBA(4),
    MENDOZA(5);

    private int numeroLocalidad;

    private Ciudad(int numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    public int getNumero() {
        return numeroLocalidad;
    }

}
