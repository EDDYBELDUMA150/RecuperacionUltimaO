/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eddybelduma.leccion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

/**
 *
 * @author OWNER
 */
@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private int id_persona;
    
    @Size(min = 3, max = 20, message = "El nombre debe tener entre 3 y 20 caracteres")
    @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;
    
    @Size(min = 3, max = 20, message = "El apellido debe tener entre 3 y 20 caracteres")
    @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido")
    private String apellido;
    
    @Size(min = 3, max = 10, message = "La cedula debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "La cedula no puede estar en blanco")
    @Column(name = "cedula")
    private String cedula;
    
    @Size(min = 3, max = 100, message = "La direccion debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;
    
    @Size(min = 3, max = 10, message = "El telefono debe tener entre 3 y 10 caracteres")
    @NotBlank(message = "El telefono no puede estar en blanco")
    @Column(name = "telefono")
    private String telefono;
    
    @Email(message = "Debe ingresar una dirección de correo válida")
    @NotBlank(message = "El correo no puede estar en blanco")
    @Column(name = "correo")
    private String correo;
    
    @Size(min = 3, max = 40, message = "La contraseña debe tener entre 3 y 40 caracteres")
    @NotBlank(message = "La contraseña no puede estar en blanco")
    @Column(name = "contrasena")
    private String contrasena;
    
    @JsonIgnore
    @OneToMany
    private List<Usuarios> listUsuarios;
}
