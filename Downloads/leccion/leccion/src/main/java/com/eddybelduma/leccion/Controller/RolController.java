/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Controller;

import com.eddybelduma.leccion.Model.Roles;
import com.eddybelduma.leccion.Services.RolServicempl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author OWNER
 */
@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    RolServicempl rolService;

    @Operation(summary = "Se obtiene la lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Roles>> listaRol() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Usuario")
    @PostMapping("/crear")
    public ResponseEntity<Roles> crearRol(@RequestBody Roles u) {
        return new ResponseEntity<>(rolService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Roles> actualizarRol(@PathVariable Integer id, @RequestBody Roles u) {
        Roles usuario = rolService.findById(id);
        if (usuario != null) {
            try {
                usuario.setNombre(u.getNombre());
                usuario.setDescripcion(u.getDescripcion());
                usuario.setEstado(u.getEstado());
                return new ResponseEntity<>(rolService.save(usuario), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Roles> elimiarRol(@PathVariable Integer id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
