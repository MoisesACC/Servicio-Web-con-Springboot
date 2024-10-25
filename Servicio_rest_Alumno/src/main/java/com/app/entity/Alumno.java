package com.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlumno;

    private String nombres;
    private String apellidos;
    private String carrera;
    private String correo;
    private String telefono;

    // Getters y Setters
    public Long getIdAlumno() { return idAlumno; }

    public void setIdAlumno(Long idAlumno) { this.idAlumno = idAlumno; }

    public String getNombres() { return nombres; }

    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }

    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCarrera() { return carrera; }

    public void setCarrera(String carrera) { this.carrera = carrera; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }
}
