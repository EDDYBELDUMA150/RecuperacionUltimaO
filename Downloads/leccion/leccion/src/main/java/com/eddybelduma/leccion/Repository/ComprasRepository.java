/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eddybelduma.leccion.Repository;

import com.eddybelduma.leccion.Model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author OWNER
 */
public interface ComprasRepository extends JpaRepository<Compras, Integer>{
    @Query(value = "Select * from Roles u where u.nombre = :nombre", nativeQuery = true)
    public Compras buscarRoles(String nombre);
}
