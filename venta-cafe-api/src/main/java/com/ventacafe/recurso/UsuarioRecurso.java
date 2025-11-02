package com.ventacafe.recurso;

import io.quarkus.panache.common.Page;
import com.ventacafe.entidad.Usuario;
import com.ventacafe.repositorio.UsuarioRepositorio;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/api/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRecurso {

    @Inject
    UsuarioRepositorio repositorio;

    @GET
    public Response listar(@QueryParam("page") @DefaultValue("0") int page,
                           @QueryParam("size") @DefaultValue("10") int size) {
        List<Usuario> usuarios = repositorio.findAll()
                                            .page(Page.of(page, size))
                                            .list();
        return Response.ok(usuarios).build(); // 200
    }

    @GET
    @Path("/{id}")
    public Response obtenerPorId(@PathParam("id") Long id) {
        Usuario usuario = repositorio.findById(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404
        }
        return Response.ok(usuario).build(); // 200
    }

    @POST
    @Transactional
    public Response crear(Usuario usuario, @Context UriInfo uriInfo) {
        repositorio.persist(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(usuario.id));
        return Response.created(builder.build()).entity(usuario).build(); // 201
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response actualizar(@PathParam("id") Long id, Usuario datos) {
        Usuario usuario = repositorio.findById(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404
        }
        usuario.nombre = datos.nombre;
        usuario.correo = datos.correo;
        usuario.rol = datos.rol;
        return Response.ok(usuario).build(); // 200
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response eliminar(@PathParam("id") Long id) {
        boolean eliminado = repositorio.deleteById(id);
        if (!eliminado) {
            return Response.status(Response.Status.NOT_FOUND).build(); // 404
        }
        return Response.noContent().build(); // 204
    }
}
