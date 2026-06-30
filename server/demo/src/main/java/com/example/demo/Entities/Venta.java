package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalTime;
@Entity
@Table(name = "venta")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;

    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;

    @ManyToOne
    @JoinColumn(name = "id_combustible")
    private Combustible combustible;

    private LocalTime hora;
    private Double galones;
    private Double importe;
}