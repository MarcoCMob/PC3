package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "combustible")
@Data
public class Combustible {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_combustible;
    private String tipo;
    private Double precio;
}