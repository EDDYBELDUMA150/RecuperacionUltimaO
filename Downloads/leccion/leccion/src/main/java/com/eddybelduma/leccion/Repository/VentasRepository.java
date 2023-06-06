/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eddybelduma.leccion.Repository;

import com.eddybelduma.leccion.Model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author OWNER
 */
public interface VentasRepository extends JpaRepository<Ventas, Integer>{
    @Query(value = "Select * from Roles u where u.nombre = :nombre", nativeQuery = true)
    public Ventas buscarRoles(String nombre);
}