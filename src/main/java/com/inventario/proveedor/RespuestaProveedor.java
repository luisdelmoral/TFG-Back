package com.inventario.proveedor;

import java.util.List;

public record RespuestaProveedor(int filasAfectadas, List<Proveedor>
listaProveedores, String error) {

}
