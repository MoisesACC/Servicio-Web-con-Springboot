package com.app.controller;

import com.app.entity.Alumno;
import com.app.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id) {
        Optional<Alumno> alumno = alumnoService.findById(id);
        return alumno.isPresent() ? ResponseEntity.ok(alumno.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id, @RequestBody Alumno alumnoDetails) {
        Optional<Alumno> alumno = alumnoService.findById(id);
        if (alumno.isPresent()) {
            Alumno updatedAlumno = alumno.get();
            updatedAlumno.setNombres(alumnoDetails.getNombres());
            updatedAlumno.setApellidos(alumnoDetails.getApellidos());
            updatedAlumno.setCarrera(alumnoDetails.getCarrera());
            updatedAlumno.setCorreo(alumnoDetails.getCorreo());
            updatedAlumno.setTelefono(alumnoDetails.getTelefono());
            return ResponseEntity.ok(alumnoService.save(updatedAlumno));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
        if (alumnoService.findById(id).isPresent()) {
            alumnoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
