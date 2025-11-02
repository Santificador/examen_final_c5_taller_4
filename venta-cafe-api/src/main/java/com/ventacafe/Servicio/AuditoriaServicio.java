package com.ventacafe.servicio;

import com.ventacafe.entidad.Auditoria;
import com.ventacafe.repositorio.AuditoriaRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;

@ApplicationScoped
public class AuditoriaServicio {

    @Inject
    AuditoriaRepositorio repositorio;

    public void registrar(String entidad, String operacion, String detalle, String usuario) {
        Auditoria auditoria = new Auditoria();
        auditoria.entidad = entidad;
        auditoria.operacion = operacion;
        auditoria.detalle = detalle;
        auditoria.fecha = LocalDateTime.now();
        auditoria.usuario = usuario;

        repositorio.persist(auditoria);
    }
}
