/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.beldumaUltimaOportunidad.controller;

import com.example.beldumaUltimaOportunidad.modelo.Ciclo;
import com.example.beldumaUltimaOportunidad.service.CicloServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/ventas")
public class CicloController {
    @Autowired
    private CicloServiceImpl cicloService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<Ciclo>> listarCiclos() {
        return new ResponseEntity<>(cicloService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Ciclo> crearCiclo(@RequestBody Ciclo p) {
        return new ResponseEntity<>(cicloService.save(p), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ciclo> actualizarCiclo(@PathVariable Long id, @RequestBody Ciclo p) {
        Ciclo v = cicloService.findById(id);
        if (v == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                v.setNombre(p.getNombre());
                v.setDescripcion(p.getDescripcion());
                v.setCarrera(p.getCarrera());
                v.setListaAsignatura(p.getListaAsignatura());
                v.setListaEstudiantes(p.getListaEstudiantes());
                v.setPeriodo(p.getPeriodo());
                return new ResponseEntity<>(cicloService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Ciclo> eliminarCiclo(@PathVariable Long id) {
        cicloService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
