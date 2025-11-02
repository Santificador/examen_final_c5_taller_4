package com.ventacafe.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "cafes")
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAFE")
    public Long id_cafe;

    @Column(name = "NOMBRE_CAFE")
    public String nombre;

    @Column(name = "DESCRIPCION_CAFE")
    public String descripcion;

    @Column(name = "PRECIO_CAFE")
    public Double precio;

    @Column(name = "ORIGEN_CAFE")
    public String origen;

    @Column(name = "TIPO_TOTADO_CAFE")
    public Integer tipoTostado;
}
