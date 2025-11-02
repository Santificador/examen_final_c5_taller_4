package com.ventacafe.repositorio;

import com.ventacafe.entidad.Auditoria;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuditoriaRepositorio implements PanacheRepository<Auditoria> {
}
