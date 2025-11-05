package com.ventacafe.util;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 * Clase utilitaria para obtener el usuario actual del contexto de seguridad.
 * Intenta obtener el usuario del JWT token si está disponible,
 * en caso contrario retorna un usuario por defecto del sistema.
 */
@ApplicationScoped
public class UsuarioContexto {

    /**
     * Obtiene el nombre del usuario actual del contexto de seguridad.
     * Si no hay un usuario autenticado, retorna "SISTEMA" como usuario por defecto.
     * 
     * @param jwtToken Token JWT opcional del usuario autenticado
     * @return Nombre del usuario o "SISTEMA" si no hay usuario autenticado
     */
    public String obtenerUsuarioActual(JsonWebToken jwtToken) {
        if (jwtToken != null && jwtToken.getName() != null) {
            return jwtToken.getName();
        }
        
        // Intentar obtener de una propiedad del sistema
        String usuarioSistema = System.getProperty("usuario.actual");
        if (usuarioSistema != null && !usuarioSistema.isEmpty()) {
            return usuarioSistema;
        }
        
        // Usuario por defecto
        return "SISTEMA";
    }

    /**
     * Método simplificado que retorna el usuario actual sin requerir el JWT token.
     * Puede ser usado en callbacks de entidades JPA.
     * 
     * @return Nombre del usuario o "SISTEMA" si no hay usuario autenticado
     */
    public static String obtenerUsuarioActual() {
        String usuarioSistema = System.getProperty("usuario.actual");
        if (usuarioSistema != null && !usuarioSistema.isEmpty()) {
            return usuarioSistema;
        }
        return "SISTEMA";
    }
}

