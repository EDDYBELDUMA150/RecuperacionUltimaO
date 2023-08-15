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
@Document(collection="Asignatura")
public class Estudiante {
    @Id
    private Long id_estudiante;
    
    private String nombre;
    private String apelldio;
    private String celular;
    private String correo;
    private String direccion;
}
