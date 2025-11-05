package com.ventacafe.entidad;

import com.ventacafe.util.UsuarioContexto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

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
