/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.beldumaUltimaOportunidad.modelo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author OWNER
 */
@Data
@Document(collection="Periodo")
public class Periodo {
    @Id
    private Long id_periodo;
    
    private String periodo;
    private int year;
    
}
