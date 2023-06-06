/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Services;

import com.eddybelduma.leccion.Model.Ventas;
import com.eddybelduma.leccion.Repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author OWNER
 */
@Service
public class VentasServiceImpl extends GenericServiceImpl<Ventas, Integer> implements GenericService<Ventas, Integer>{

    @Autowired
    VentasRepository ventRepository;
    
    @Override
    public CrudRepository<Ventas, Integer> getDao() {
        return ventRepository;
    }
    
}
