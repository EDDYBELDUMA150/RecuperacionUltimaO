/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ExamenPracticoM5B.Controller;

import com.example.ExamenPracticoM5B.Model.Producto;
import com.example.ExamenPracticoM5B.Service.ProductoServiceImpl;
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
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    ProductoServiceImpl producService;

    @Operation(summary = "Lista de productos")
    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> listaCompras() {
        return new ResponseEntity<>(producService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos de producto")
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearCompras(@RequestBody Producto u) {
        producService.calcularYGuardar(u);
        return new ResponseEntity<>(producService.save(u), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un producto")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarCompras(@PathVariable Integer id, @RequestBody Producto u) {
        Producto prodct = producService.findById(id);
        if (prodct != null) {
            try {
                prodct.setDescripcion(u.getDescripcion());
                prodct.setCantidad(u.getCantidad());
                prodct.setPrecio(u.getPrecio());
                prodct.setDescuento(u.getDescuento());
                prodct.setIva(u.getIva());
                prodct.setSubtotal(u.getSubtotal());
                prodct.setPvp(u.getPvp());
                return new ResponseEntity<>(producService.save(prodct), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Eliminar un producto")
    public ResponseEntity<Producto> elimiarProducto(@PathVariable Integer id) {
        producService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}
