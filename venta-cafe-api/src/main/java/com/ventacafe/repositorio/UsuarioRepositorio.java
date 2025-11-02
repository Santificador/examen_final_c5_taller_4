package com.ventacafe.repositorio;

import com.ventacafe.entidad.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepositorio implements PanacheRepository<Usuario> {
}
