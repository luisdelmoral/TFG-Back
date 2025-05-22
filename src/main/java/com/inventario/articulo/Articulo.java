package com.inventario.articulo;

import java.math.BigDecimal;

public record Articulo(Long id, Long marcaId, String nombre, String descripcion, 
    BigDecimal precio, int cantidad, boolean descatalogado) {

}
