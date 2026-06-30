package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Entities.Trabajador;
import com.example.demo.Service.GrifoService;
import com.example.demo.dto.VentaReporteDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Para que puedas probarlo desde cualquier lado
@RequiredArgsConstructor
public class GrifoController {

    private final GrifoService grifoService;

    // 1. Buscar trabajador por nombre (devuelve DNI, NOMBRE, TURNO)
    @GetMapping("/trabajadores/buscar")
    public List<Trabajador> buscarTrabajador(@RequestParam String nombre) {
        return grifoService.buscarPorNombre(nombre);
    }

    // 2. Reporte de ventas por DNI
    @GetMapping("/ventas/reporte/{dni}")
    public List<VentaReporteDTO> reportePorDni(@PathVariable String dni) {
        return grifoService.obtenerVentasPorDni(dni);
    }

    // CRUD: Listar todos los trabajadores
    @GetMapping("/trabajadores")
    public List<Trabajador> listar() {
        return grifoService.listarTodos();
    }

    // CRUD: Insertar trabajador
    @PostMapping("/trabajadores")
    public Trabajador crear(@RequestBody Trabajador t) {
        return grifoService.guardarTrabajador(t);
    }
}