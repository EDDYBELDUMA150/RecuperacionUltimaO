/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.beldumaUltimaOportunidad.service;

import com.example.beldumaUltimaOportunidad.modelo.Ciclo;
import com.example.beldumaUltimaOportunidad.repository.CicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author OWNER
 */
@Service
public class CicloServiceImpl extends GenericServiceImpl<Ciclo, Long> implements GenericService<Ciclo, Long>{

    @Autowired
    private CicloRepository ventasRespository;
    
    @Override
    public CrudRepository<Ciclo, Long> getDao() {
        return ventasRespository;
    }
    
}
