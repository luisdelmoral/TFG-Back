use Inventario;

create table marcas (
	id int auto_increment primary key,
	foreign key (clases_id) references clases(id), 
	foreign key (contactos_id) references contactos(id),
	nombre varchar(50) unique,
	descripcion varchar(500)
);

create table clases (
	id int auto_increment primary key,
    clase varchar(20)
);

create table contactos (
	id int auto_increment primary key,
    nombre varchar(20),
    apellidos varchar(20),
    email varchar(50),
    telefono int
);

create table proveedores (
	id int auto_increment primary key,
    foreign key (marcas_id) references marcas(id),
    foreign key (contactos_id) references clases(id),
	nombre varchar(50),
    descripcion varchar(500),
    direccion varchar(50)
);

create table articulos (
	id int auto_increment primary key,
    foreign key (marcas_id) references marcas(id),
    foreign key (proveedores_id) references proveedores(id),
    nombre varchar(50),
    descripcion varchar(500),
    precio decimal(20,2),
    cantidad int 
);

create table usuario (
	id int auto_increment primary key,
    nombre_usario varchar(50),
    password varchar(100)
);