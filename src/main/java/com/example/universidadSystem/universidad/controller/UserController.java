package com.example.universidadSystem.universidad.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.universidadSystem.universidad.model.Universidad;
import com.example.universidadSystem.universidad.services.UniversidadService;

@RestController
@RequestMapping("/universidad")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UniversidadService universidadService;

    @GetMapping("")
    public String saludo() {
        return "Pagina principal";
    }

    @GetMapping("/get")
    public ArrayList<Universidad> getUni() {
        return (ArrayList<Universidad>) universidadService.getAllUniversidad();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUniversidad(@RequestBody Universidad universidad) {
        String res = "didn't worked!";
        try {
            universidadService.createUniversidad(universidad);
            res = universidad.toString();
        } catch (RuntimeException e) {
            res = "Failed to create entry!: " + e;
        }
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUniversidad(@PathVariable Long id, @RequestBody Universidad universidad) {
        String res = "There was an error!";
        try {
            String messageReturned = universidadService.actualizarUni(id, universidad);
            res = messageReturned;
        } catch (RuntimeException e) {
            res += e;
        }

        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/get/{id}")
    public Optional<Universidad> getById(@PathVariable Long id) {
        return universidadService.getUsingId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUniversidad(@PathVariable Long id) {
        String res;
        try {
            universidadService.deleteUni(id);
            res = "Was succesfull!";
        } catch (RuntimeException e) {
            res = "Unable to delete the entry";
        }
        return res;
    }

}
