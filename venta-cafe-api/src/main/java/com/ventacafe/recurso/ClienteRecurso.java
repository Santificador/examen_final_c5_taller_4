package com.ventacafe.recurso;

import com.ventacafe.entidad.Cliente;
import com.ventacafe.repositorio.ClienteRepositorio;
import io.quarkus.panache.common.Page;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/api/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteRecurso {

    @Inject
    ClienteRepositorio repositorio;

    @GET
    public Response listar(@QueryParam("page") @DefaultValue("0") int page,
                           @QueryParam("size") @DefaultValue("10") int size) {
        List<Cliente> clientes = repositorio.findAll()
                                            .page(Page.of(page, size))
                                            .list();
        return Response.ok(clientes).build();
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Long id) {
        Cliente cliente = repositorio.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cliente).build();
    }

    @POST
    @Transactional
    public Response crear(Cliente cliente, @Context UriInfo uriInfo) {
        repositorio.persist(cliente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(cliente.id_cliente));
        return Response.created(builder.build()).entity(cliente).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response actualizar(@PathParam("id") Long id, Cliente datos) {
        Cliente cliente = repositorio.findById(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        cliente.nombre = datos.nombre;
        cliente.apellido = datos.apellido;
        cliente.email = datos.email;
        cliente.telefono = datos.telefono;
        cliente.direccion = datos.direccion;
        return Response.ok(cliente).build();
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
