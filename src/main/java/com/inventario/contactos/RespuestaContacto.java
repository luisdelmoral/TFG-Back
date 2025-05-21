package com.inventario.contactos;

import java.util.List;

public record RespuestaContacto(int filasAfectadas, List<Contacto> listaContactos, String error) {

}
