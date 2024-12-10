DROP DATABASE IF EXISTS ZonaACME;

CREATE DATABASE ZonaACME;
USE ZonaACME;

DROP TABLE IF EXISTS TipoUsuario;
DROP TABLE IF EXISTS Empresa;
DROP TABLE IF EXISTS Usuarios;
DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS Anotaciones;
DROP TABLE IF EXISTS Registro;
DROP TABLE IF EXISTS Log;

CREATE TABLE IF NOT EXISTS TipoUsuario (
    IdTipo INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Nombre VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Empresa (
    IdEmpresa INTEGER PRIMARY KEY NOT NULL UNIQUE,
    Nombre VARCHAR(110) UNIQUE
);

CREATE TABLE IF NOT EXISTS Usuarios (
    IdUsuario INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Contrasena VARCHAR(20) NOT NULL,
    Activo BOOLEAN NOT NULL DEFAULT TRUE,
    IdTipoUsuario INTEGER NOT NULL,
    IdEmpresa INTEGER,
    FOREIGN KEY (IdTipoUsuario) REFERENCES TipoUsuario(IdTipo),
    FOREIGN KEY (IdEmpresa) REFERENCES Empresa(IdEmpresa)
);

CREATE TABLE IF NOT EXISTS Persona (
    Documento INTEGER PRIMARY KEY NOT NULL UNIQUE,
    Nombre VARCHAR(100) NOT NULL,
    Activo BOOLEAN NOT NULL DEFAULT TRUE,
    Tipo ENUM("Trabajador", "Invitado") NOT NULL,
    Estado ENUM("Activo", "Inactivo") NOT NULL,
    IdEmpresa INTEGER NOT NULL,
    haSalido BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (IdEmpresa) REFERENCES Empresa(IdEmpresa)
);

CREATE TABLE IF NOT EXISTS Anotaciones (
    IdAnotacion INTEGER PRIMARY KEY NOT NULL UNIQUE,
    Documento INTEGER NOT NULL,
    Tipo ENUM("Restricción", "Levantamiento", "Advertencia"),
    Mensaje VARCHAR(500),
    Fecha DATETIME NOT NULL,
    FOREIGN KEY (Documento) REFERENCES Persona(Documento)
);

CREATE TABLE IF NOT EXISTS Registro (
    IdRegistro INTEGER PRIMARY KEY NOT NULL UNIQUE,
    Documento INTEGER NOT NULL,
    Fecha DATETIME NOT NULL,
    IdUsuario INTEGER NOT NULL,
    IdAnotacion INTEGER,
    TipoRegistro ENUM("Salida", "Entrada") NOT NULL,
    PlacaVehiculo CHAR(7),
    FOREIGN KEY (Documento) REFERENCES Persona(Documento),
    FOREIGN KEY (IdUsuario) REFERENCES Usuarios(IdUsuario),
    FOREIGN KEY (IdAnotacion) REFERENCES Anotaciones(IdAnotacion)
);

CREATE TABLE IF NOT EXISTS Log (
    IdLog INTEGER PRIMARY KEY NOT NULL UNIQUE,
    Fecha DATETIME NOT NULL,
    Observacion VARCHAR(500) NOT NULL,
    IdUsuario INTEGER,
    FOREIGN KEY (IdUsuario) REFERENCES Usuarios(IdUsuario)
);

INSERT INTO `TipoUsuario`(`Nombre`) VALUES
("SuperUsuario"),
("Supervisor"),
("Guarda"),
("Funcionario");


INSERT INTO `Usuarios`(`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
("juanito","123",TRUE,1,NULL);

CREATE TABLE IF NOT EXISTS Usuarios (
    IdUsuario INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    Contrasena VARCHAR(20) NOT NULL,
    Activo BOOLEAN NOT NULL DEFAULT TRUE,
    IdTipoUsuario INTEGER NOT NULL,
    IdEmpresa INTEGER NOT NULL,
    FOREIGN KEY (IdTipoUsuario) REFERENCES TipoUsuario(IdTipo),
    FOREIGN KEY (IdEmpresa) REFERENCES Empresa(IdEmpresa)
);

/* INSERT INTO `Usuarios`(`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
("juanito","123",TRUE,1,NULL); */

DELETE FROM `Usuarios`;