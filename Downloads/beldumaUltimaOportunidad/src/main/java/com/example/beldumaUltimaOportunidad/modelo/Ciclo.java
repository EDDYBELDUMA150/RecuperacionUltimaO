/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.beldumaUltimaOportunidad.modelo;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author OWNER
 */
@Data
@Document(collection="Ciclo")
public class Ciclo {
    @Id
    private Long id_ciclo;
    
    private String descripcion;
    private String nombre;
    private List<Estudiante> listaEstudiantes;
    private List<Asignatura> listaAsignatura;
    private Carrera carrera;
    private Periodo periodo;
}
