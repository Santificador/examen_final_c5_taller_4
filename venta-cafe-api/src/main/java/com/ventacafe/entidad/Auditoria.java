package com.ventacafe.entidad;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditorias")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "ENTIDAD")
    public String entidad;

    @Column(name = "OPERACION")
    public String operacion;

    @Column(name = "DETALLE")
    public String detalle;

    @Column(name = "FECHA")
    public LocalDateTime fecha;

    @Column(name = "USUARIO")
    public String usuario;
}
