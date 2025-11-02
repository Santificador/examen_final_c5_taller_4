package com.ventacafe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CafeDTO {

    public Long id;

    @NotBlank(message = "El nombre del café es obligatorio")
    public String nombre;

    public String descripcion;

    @NotNull(message = "El precio es obligatorio")
    public Double precio;

    public String origen;

    public Integer tipoTostado;
}
