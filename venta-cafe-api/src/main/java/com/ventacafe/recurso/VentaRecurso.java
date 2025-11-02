package com.ventacafe.recurso;

import com.ventacafe.entidad.Venta;
import com.ventacafe.repositorio.VentaRepositorio;
import io.quarkus.panache.common.Page;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/api/ventas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VentaRecurso {

    @Inject
    VentaRepositorio repositorio;

    @GET
    public Response listar(@QueryParam("page") @DefaultValue("0") int page,
                           @QueryParam("size") @DefaultValue("10") int size) {
        List<Venta> ventas = repositorio.findAll()
                                        .page(Page.of(page, size))
                                        .list();
        return Response.ok(ventas).build();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Long id) {
        Venta venta = repositorio.findById(id);
        if (venta == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(venta).build();
    }

    @POST
    @Transactional
    public Response crear(Venta venta, @Context UriInfo uriInfo) {
        repositorio.persist(venta);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(venta.id));
        return Response.created(builder.build()).entity(venta).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response actualizar(@PathParam("id") Long id, Venta datos) {
        Venta venta = repositorio.findById(id);
        if (venta == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        venta.cliente = datos.cliente;
        venta.cafe = datos.cafe;
        venta.cantidad = datos.cantidad;
        venta.precioUnitario = datos.precioUnitario;
        venta.montoTotal = datos.montoTotal;
        venta.fecha = datos.fecha;
        return Response.ok(venta).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response eliminar(@PathParam("id") Long id) {
        boolean eliminado = repositorio.deleteById(id);
        if (!eliminado) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }
}
