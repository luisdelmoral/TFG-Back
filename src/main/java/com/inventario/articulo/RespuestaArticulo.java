package com.inventario.articulo;

import java.util.List;

public record RespuestaArticulo(int filasAfectadas, List<Articulo> listaArticulos, String error) {

}
