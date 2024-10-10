create database siesweb;
use siesweb;

CREATE TABLE TipoDocumento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion_tipo VARCHAR(100) NOT NULL
);
create table Proyectos(
	id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL unique,
    estado VARCHAR(100) NOT NULL,
    ubicacion VARCHAR(100) not null
);
create table Roles (
	id int auto_increment primary key,
    descripcion_rol varchar(20)
);
CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(24) NOT NULL,
    apellido varchar(24) not null,
    documento varchar(10) not null unique,    
    email VARCHAR(100) NOT NULL unique,
    telefono varchar(14) not null unique,
    usuario varchar(24) not null unique,
    contraseña varchar(10) not null unique,
    estado varchar(10) not null,
    tipo_documento_id_usuario INT,
    proyecto_id_usuario INT,
    rol_id_usuario int,
    FOREIGN KEY (tipo_documento_id_usuario) REFERENCES TipoDocumento(id),
    foreign key (proyecto_id_usuario) references Proyectos(id),
    foreign key (rol_id_usuario) references Roles(id)
);
create table Temas (
	id int auto_increment primary key,
    descripcion_tema varchar(10) not null
);
create table Solicitudes (
	id int auto_increment primary key,
    observacion varchar(100),
    proyecto_id_solicitud int,
    tema_id_solicitud int,
    usuario_id_solicitud int,
    foreign key (proyecto_id_solicitud) references Proyectos(id),
    foreign key (tema_id_solicitud) references Temas(id),
    foreign key (usuario_id_solicitud) references Usuarios(id)
);
create table Avances (
	id int auto_increment primary key,
    fecha date not null,
    tramo_amp varchar(7) not null,
    tramp_mej varchar(7) not null,
    tramo_sub varchar(7) not null,
    tramo_bas varchar(7) not null,
    tramo_asf varchar(7) not null,
    cunetas varchar(4) not null,
    muros varchar(4) not null,
    porcentaje_ejecucion varchar(3) not null,
    proyecto_id_avance int,
    foreign key (proyecto_id_avance) references Proyectos(id)
);

insert into Proyectos (titulo,estado,ubicacion) VALUES ("Pavimentacion PALMITAS-LERMA","Terminado","Lerma");
insert into TipoDocumento (descripcion_tipo) VALUES ("Tarjeta de identidad");
insert into Roles (descripcion_rol) values ("Invitado");
insert into Temas (descripcion_tema) values ("Otros");

ALTER TABLE Usuarios DROP COLUMN estado;
describe Usuarios;
select * from Usuarios;