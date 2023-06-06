/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Services;

import com.eddybelduma.leccion.Model.Compras;
import com.eddybelduma.leccion.Model.Productos;
import com.eddybelduma.leccion.Repository.ComprasRepository;
import com.eddybelduma.leccion.Repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author OWNER
 */
@Service
public class ProductosServiceImpl extends GenericServiceImpl<Productos, Integer> implements GenericService<Productos, Integer>{

    @Autowired
    ProductosRepository prodRepository;
    
    @Override
    public CrudRepository<Productos, Integer> getDao() {
        return prodRepository;
    }
    
}
