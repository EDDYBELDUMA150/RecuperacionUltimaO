/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Controller;

import com.eddybelduma.leccion.Model.Persona;
import com.eddybelduma.leccion.Services.PersonaServicempl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author OWNER
 */
@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaServicempl personaService;
    
    @Operation(summary = "Lista de personas")
    @GetMapping("/listar")
    public ResponseEntity<List<Persona>> listaPersonas(){
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersonas(@PathVariable Integer id, @RequestBody Persona u) {
        Persona persona = personaService.findById(id);
        if (persona != null) {
            try {
                persona.setNombre(u.getNombre());
                persona.setApellido(u.getApellido());
                persona.setCorreo(u.getCorreo());
                persona.setCedula(u.getCedula());
                persona.setDireccion(u.getDireccion());
                persona.setContrasena(u.getContrasena());
                persona.setCorreo(u.getCorreo());
                persona.setTelefono(u.getTelefono());
                return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Persona> elimiarPersonas(@PathVariable Integer id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
