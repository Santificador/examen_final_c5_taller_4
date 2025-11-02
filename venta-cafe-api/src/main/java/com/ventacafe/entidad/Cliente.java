package com.ventacafe.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    public Long id_cliente;

    @Column(name = "NOMBRE")
    public String nombre;

    @Column(name = "APELLIDO")
    public String apellido;

    @Column(name = "EMAIL")
    public String email;

    @Column(name = "TELEFONO")
    public String telefono;

    @Column(name = "DIRECCION")
    public String direccion;
}
