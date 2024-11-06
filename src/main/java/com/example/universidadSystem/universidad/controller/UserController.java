package com.example.universidadSystem.universidad.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.example.universidadSystem.universidad.DTO.UniversidadDTO;
import com.example.universidadSystem.universidad.model.Universidad;
import com.example.universidadSystem.universidad.model.Usuario;
import com.example.universidadSystem.universidad.services.UniversidadService;
import com.example.universidadSystem.universidad.services.UserApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/universidad")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UniversidadService universidadService;

    @Autowired
    UserApiService userApiService;

    @GetMapping("")
    public String saludo() {
        return "Pagina principal";
    }

    @GetMapping("/get")
    @Operation(summary = "Obtener todas las universidades", description = "Obtener todas las universidades con información de contacto")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Response Ok") })
    @ApiResponse(responseCode = "404", description = "Bad Request")
    public ArrayList<Universidad> getUni() {
        return (ArrayList<Universidad>) universidadService.getAllUniversidad();
    }

    @GetMapping("/getContacts")
    @Operation(summary = "Get only the contact info of each university")
    public List<UniversidadDTO> getContactInfo() {
        return universidadService.getContactInfo();
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
    @Operation(summary = "Actualizar una universidad")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado con éxito")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    public ResponseEntity<String> updateUniversidad(
            @Parameter(description = "ID de la universidad a actualizar") @PathVariable Long id,
            @RequestBody Universidad universidad) {
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

    @GetMapping("/usuarios")
    @Operation(summary = "Obtener los usuarios del sistema", description = "Obtener todos los usuarios,")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Usuario.class), examples = @ExampleObject(value = "{\"id\": 1,\r\n"
                    + //
                    "\"firstname\": \"John\",\r\n" + //
                    "\"lastname\": \"Doe\",\r\n" + //
                    "\"email\": \"johndoe@example.com\"\r\n" + //
                    "}"))),
            @ApiResponse(responseCode = "400", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiResponse.class), examples = @ExampleObject(value = "{\"mensaje\": \"Error obtaining the users\", \r\n"
                    + //
                    "\"codigo\" : \"400\" \r\n" +
                    "}"))) })

    public List<Usuario> getUsuarios() {
        return userApiService.getListOfUsers();
    }

}