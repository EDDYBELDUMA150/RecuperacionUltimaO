/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.evaluacion3M5_B.service;

import com.example.evaluacion3M5_B.model.Profesor;
import com.example.evaluacion3M5_B.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author OWNER
 */
@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long> implements GenericService<Profesor, Long>{
    @Autowired
    ProfesorRepository profeRepository;
    
    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return profeRepository;
    }
}
