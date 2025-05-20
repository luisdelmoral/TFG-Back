package com.inventario;

public class Constantes {

        public static final String INSERTAR_CATEGORIA = "insert into categorias (nombre_categoria) values ('%s')";

        public static final String GET_CATEGORIA = "select id,nombre_categoria from categorias where id=%h";

        public static final String RESULTADO_CATEGORIA = "{\"filasAfectadas\":%h,\"error\":\"%s\"}";

        public static final String GET_ALL_CATEGORIA = "select * from categorias";

}
