/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.evaluacion3M5_B.repository;

import com.example.evaluacion3M5_B.model.Profesor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author OWNER
 */
public interface ProfesorRepository extends MongoRepository<Profesor, Long>{
    
}
