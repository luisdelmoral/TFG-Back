package com.inventario;

public class Constantes {

        public static final String INSERTAR_CATEGORIA = "insert into categorias (nombre_categoria) values ('%s')";

        public static final String GET_CATEGORIA = "select id,nombre_categoria from categorias where id=%d";

        public static final String GET_ALL_CATEGORIA = "select * from categorias";

        public static final String INSERTAR_CONTACTO = "insert into contactos (nombre, apellidos, email, telefono) values ('%s', '%s', '%s', %d )";

        public static final String GET_CONTACTO = "select * from contactos where id=%d";

        public static final String GET_ALL_CONTACTO = "select * from contactos"; 

        public static final String INSERTAR_MARCA = "insert into marcas (nombre, categorias_id, contactos_id, descripcion) values ('%s', %d, %d, '%s')";

        public static final String GET_MARCA = "select * from marcas where id=%d";

        public static final String GET_ALL_MARCA = "select * from marcas"; 

        public static final String INSERTAR_PROVEEDOR = "insert into proveedores (marcas_id, contactos_id, nombre, direccion, descripcion) values (%d, %h, '%s', '%s', '%s' )";
        
        public static final String GET_PROVEEDOR = "select * from proveedores where id=%d";
        
        public static final String GET_ALL_PROVEEDOR = "select * from proveedores";

        public static final String INSERTAR_ARTICULO = "insert into articulos (marcas_id, nombre, precio, cantidad, descatalogado, descripcion) values (%d, '%s', %s, %d, %b, '%s')";

        public static final String GET_ARTICULO = "select * from articulos where id=%d";

        public static final String GET_ALL_ARTICULO = "select * from articulos";

        public static final String ELIMINAR_ARTICULO = "delete from articulos where id=%d";

        public static final String ACTUALIZAR_ARTICULO = "update articulos set nombre='%s' descripcion='%s' precio=%s cantidad=%d descatalogado=%b where id=%d";
         



}       
