/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ExamenPracticoM5B.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Data;

/**
 *
 * @author OWNER
 */
@Entity
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id_producto;

    @Column(nullable = false, length = 100)
    private String descripcion;

    @Column(nullable = false, scale = 2)
    @DecimalMin(value = "0.01", inclusive = false)
    private double precio;

    @Column(nullable = false)
    @Min(value = 1)
    private int cantidad;

    @Column(nullable = false, scale = 2)
    @DecimalMin(value = "0.00", inclusive = false)
    private double descuento;

    @Column(nullable = false, scale = 2)
    @DecimalMin(value = "0.01", inclusive = false)
    private double iva = 0.12;

    @Column(nullable = false, scale = 2)
    @DecimalMin(value = "0.01", inclusive = false)
    private double subtotal;

    @Column(nullable = false, scale = 2)
    @DecimalMin(value = "0.01", inclusive = false)
    private double pvp;
    
    public void calcularPVP() {
        subtotal = precio * cantidad;

        if (subtotal > 50) {
            descuento = subtotal * 0.10;
        } else {
            descuento = 0;
        }

        iva = descuento*0.12;
        pvp = (subtotal-descuento) + iva;
    }

}
