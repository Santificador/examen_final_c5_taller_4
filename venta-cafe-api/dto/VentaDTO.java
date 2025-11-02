package com.ventacafe.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class VentaDTO {

    public Long id;

    @NotNull(message = "Debe indicar el ID del cliente")
    public Long idCliente;

    @NotNull(message = "Debe indicar el ID del café")
    public Long idCafe;

    @NotNull(message = "Debe indicar la cantidad")
    public Integer cantidad;

    public Double precioUnitario;

    public Double montoTotal;

    public LocalDate fecha;
}
