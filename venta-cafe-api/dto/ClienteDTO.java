package com.ventacafe.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

    public Long id;

    @NotBlank(message = "El nombre es obligatorio")
    public String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    public String apellido;

    @Email(message = "Debe ser un correo válido")
    public String email;

    @Size(min = 6, message = "El teléfono debe tener al menos 6 caracteres")
    public String telefono;

    public String direccion;
}
