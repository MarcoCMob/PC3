package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.Trabajador;
import com.example.demo.dto.VentaReporteDTO;
import com.example.demo.Repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrifoService {

    private final TrabajadorRepository trabajadorRepository;
    private final VentaRepository ventaRepository;

    public GrifoService(
            TrabajadorRepository trabajadorRepository,
            VentaRepository ventaRepository
    ) {
        this.trabajadorRepository = trabajadorRepository;
        this.ventaRepository = ventaRepository;
    }

    // Consulta 1: Buscar trabajadores por nombre
    public List<Trabajador> buscarPorNombre(String nombre) {
        return trabajadorRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Consulta 2: Ventas por DNI de trabajador
    public List<VentaReporteDTO> obtenerVentasPorDni(String dni) {
        return ventaRepository.findByTrabajadorDni(dni).stream()
                .map(v -> new VentaReporteDTO(
                        v.getHora(),
                        v.getCombustible().getTipo(),
                        v.getImporte()
                ))
                .collect(Collectors.toList());
    }

    // CRUD Básico Trabajador
    public Trabajador guardarTrabajador(Trabajador t) {
        return trabajadorRepository.save(t);
    }

    public List<Trabajador> listarTodos() {
        return trabajadorRepository.findAll();
    }
}