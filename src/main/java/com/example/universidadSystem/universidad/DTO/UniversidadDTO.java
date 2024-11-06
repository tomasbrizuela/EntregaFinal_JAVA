package com.example.universidadSystem.universidad.DTO;

public class UniversidadDTO {
    private String nombre;
    private String web;
    private String email;
    private String telefono;

    public UniversidadDTO(String nombre, String web, String email, String telefono) {
        this.nombre = nombre;
        this.web = web;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
