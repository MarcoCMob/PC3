package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "trabajador")
@Data
public class Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_trabajador;
    
    private String nombre;
    private String turno; // Puedes usar Enum si lo prefieres
    private String dni;
}