/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.beldumaUltimaOportunidad.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author OWNER
 */
public interface GenericService <T, ID extends Serializable> {

    public List<T> findByAll();

    public T save(T entity);

    public T findById(ID id);

    public void delete(ID id);

}
