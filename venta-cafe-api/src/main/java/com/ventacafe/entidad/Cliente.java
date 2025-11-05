package com.ventacafe.entidad;

import com.ventacafe.util.UsuarioContexto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    // Campos de auditoría
    @Column(name = "USUARIO_CREACION")
    public String usuarioCreacion;

    @Column(name = "USUARIO_MODIFICACION")
    public String usuarioModificacion;

    @Column(name = "FECHA_CREACION")
    public LocalDateTime fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    public LocalDateTime fechaModificacion;

    /**
     * Callback ejecutado antes de persistir una nueva entidad.
     * Establece automáticamente la fecha y usuario de creación.
     */
    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        usuarioCreacion = UsuarioContexto.obtenerUsuarioActual();
        fechaModificacion = LocalDateTime.now();
        usuarioModificacion = UsuarioContexto.obtenerUsuarioActual();
    }

    /**
     * Callback ejecutado antes de actualizar una entidad existente.
     * Actualiza automáticamente la fecha y usuario de modificación.
     */
    @PreUpdate
    protected void onUpdate() {
        fechaModificacion = LocalDateTime.now();
        usuarioModificacion = UsuarioContexto.obtenerUsuarioActual();
    }
}
