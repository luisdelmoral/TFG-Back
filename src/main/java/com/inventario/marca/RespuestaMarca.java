package com.inventario.marca;

import java.util.List;

public record RespuestaMarca(int filasAfectadas, List<Marca> listaMarcas, String error) {

}
