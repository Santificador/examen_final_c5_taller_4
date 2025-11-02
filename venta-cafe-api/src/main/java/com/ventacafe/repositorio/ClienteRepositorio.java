package com.ventacafe.repositorio;

import com.ventacafe.entidad.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepositorio implements PanacheRepository<Cliente> {
}
