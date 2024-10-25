package com.app.service;

import com.app.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> findAll();

    Optional<Alumno> findById(Long id);

    Alumno save(Alumno alumno);

    void deleteById(Long id);
}
