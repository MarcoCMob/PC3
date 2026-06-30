package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class VentaReporteDTO {
    private LocalTime hora;
    private String tipoCombustible;
    private Double importe;
}
