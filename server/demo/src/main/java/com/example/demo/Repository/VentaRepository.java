package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Venta;

import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByTrabajadorDni(String dni);
}