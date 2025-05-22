package com.inventario;

public class Constantes {

        public static final String INSERTAR_CATEGORIA = "insert into categorias (nombre_categoria) values ('%s')";

        public static final String GET_CATEGORIA = "select id,nombre_categoria from categorias where id=%h";

        public static final String GET_ALL_CATEGORIA = "select * from categorias";

        public static final String INSERTAR_CONTACTO = "insert into contacto (nombre, apellidos, email, telefono) values ('%s', '%s', '%s', %h )";

        public static final String GET_CONTACTO = "select * from contactos where id=%h";

        public static final String GET_ALL_CONTACTO = "select * from contactos"; 

        public static final String INSERTAR_MARCA = "insert into marca (nombre, categorias_id, contactos_id, descripcion) values ('%s', %h, %h, '%s')";

        public static final String GET_MARCA = "select * from marcas where id=%h;";

        public static final String GET_ALL_MARCA = "select * from marcas"; 

        public static final String INSERTAR_PROVEEDOR = "insert into proveedor (marcas_id, contactos_id, nombre, direccion, descripcion) values (%h, %h, '%s', '%s', '%s' )";
        
        public static final String GET_PROVEEDOR = "select * from proveedores where id=%h;";
        
        public static final String GET_ALL_PROVEEDOR = "select * from proveedores";

        public static final String INSERTAR_ARTICULO = "insert into articulo (marcas_id, nombre, precio, cantidad, descatalogado, descripcion)";

        public static final String GET_ARTICULO = "select * from articulos where id=%h;";

        public static final String GET_ALL_ARTICULO = "select * from articulos";
         



}       
