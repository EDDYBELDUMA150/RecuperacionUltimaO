/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.ExamenPracticoM5B.Repository;

import com.example.ExamenPracticoM5B.Model.Producto;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author OWNER
 */
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    @Query(value = "Select * from producto u where u.descripcion = :descripcion", nativeQuery = true)
    public Producto buscarProducto(String descripcion);
}
