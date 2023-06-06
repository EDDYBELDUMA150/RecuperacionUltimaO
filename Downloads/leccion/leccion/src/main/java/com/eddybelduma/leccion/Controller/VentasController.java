/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Controller;

import com.eddybelduma.leccion.Model.Ventas;
import com.eddybelduma.leccion.Services.VentasServiceImpl;
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
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    VentasServiceImpl ventService;

    @Operation(summary = "Se obtiene la lista de Usuarios")
    @GetMapping("/listar")
    public ResponseEntity<List<Ventas>> listaUsuarios() {
        return new ResponseEntity<>(ventService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del Usuario")
    @PostMapping("/crear")
    public ResponseEntity<Ventas> crearUsuario(@RequestBody Ventas u) {
        return new ResponseEntity<>(ventService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Ventas> actualizarUsuario(@PathVariable Integer id, @RequestBody Ventas u) {
        Ventas ventas = ventService.findById(id);
        if (ventas != null) {
            try {
                ventas.setCliente(u.getCliente());
                ventas.setProducto_adq(u.getProducto_adq());
                ventas.setCantidad(u.getCantidad());
                ventas.setPrecio(u.getPrecio());
                ventas.setFecha_venta(u.getFecha_venta());
                return new ResponseEntity<>(ventService.save(ventas), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Ventas> elimiarUsuario(@PathVariable Integer id) {
        ventService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
