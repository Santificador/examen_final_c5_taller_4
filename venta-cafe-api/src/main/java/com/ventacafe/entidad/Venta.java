package com.ventacafe.entidad;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    public Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_CAFE")
    public Cafe cafe;

    @Column(name = "CANTIDAD_VENTAS")
    public Integer cantidad;

    @Column(name = "PRECIO_UNITARIO_VENTAS")
    public Double precioUnitario;

    @Column(name = "MONTO_TOTAL_VENTAS")
    public Double montoTotal;

    @Column(name = "FECHA_VENTAS")
    public LocalDate fecha;
}
