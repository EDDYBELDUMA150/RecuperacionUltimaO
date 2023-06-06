/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Services;

import com.eddybelduma.leccion.Model.Roles;
import com.eddybelduma.leccion.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


/**
 *
 * @author OWNER
 */
@Service
public class RolServicempl extends GenericServiceImpl<Roles, Integer> implements GenericService<Roles, Integer>{

    @Autowired
    RolRepository rolRepository;
    
    @Override
    public CrudRepository<Roles, Integer> getDao() {
        return rolRepository;
    }
    
}
