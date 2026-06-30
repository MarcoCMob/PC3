package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Trabajador;

import java.util.List;
import java.util.Optional;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    List<Trabajador> findByNombreContainingIgnoreCase(String nombre);
    Optional<Trabajador> findByDni(String dni);
}