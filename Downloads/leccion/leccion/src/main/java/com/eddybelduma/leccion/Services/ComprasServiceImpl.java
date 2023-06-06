/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Services;

import com.eddybelduma.leccion.Model.Compras;
import com.eddybelduma.leccion.Repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author OWNER
 */
@Service
public class ComprasServiceImpl extends GenericServiceImpl<Compras, Integer> implements GenericService<Compras, Integer>{

    @Autowired
    ComprasRepository ventRepository;
    
    @Override
    public CrudRepository<Compras, Integer> getDao() {
        return ventRepository;
    }
    
}
