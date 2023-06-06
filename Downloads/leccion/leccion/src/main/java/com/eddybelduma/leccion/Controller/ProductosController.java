/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Controller;

import com.eddybelduma.leccion.Model.Persona;
import com.eddybelduma.leccion.Model.Productos;
import com.eddybelduma.leccion.Services.ProductosServiceImpl;
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
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    ProductosServiceImpl productoService;
    
    @Operation(summary = "Se obtiene la lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Productos>> listaProductos() {
        return new ResponseEntity<>(productoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Usuario")
    @PostMapping("/crear")
    public ResponseEntity<Productos> crearProductos(@RequestBody Productos u) {
        return new ResponseEntity<>(productoService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Productos> actualizarProductos(@PathVariable Integer id, @RequestBody Productos u) {
        Productos producto = productoService.findById(id);
        if (producto != null) {
            try {
                producto.setNombre(u.getNombre());
                producto.setDescripcion(u.getDescripcion());
                producto.setCategoria(u.getCategoria());
                producto.setPrecio_emprendedor(u.getPrecio_emprendedor());
                producto.setImagenes(u.getImagenes());
                producto.setAdicional(u.getAdicional());
                return new ResponseEntity<>(productoService.save(producto), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Persona> elimiarProductos(@PathVariable Integer id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
