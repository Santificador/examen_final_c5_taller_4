package com.ventacafe.repositorio;

import com.ventacafe.entidad.Venta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VentaRepositorio implements PanacheRepository<Venta> {
}
