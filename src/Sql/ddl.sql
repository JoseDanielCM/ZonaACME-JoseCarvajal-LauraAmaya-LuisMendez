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
    IdEmpresa INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Nombre VARCHAR(110) UNIQUE,
    Activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS Usuarios (
    Documento INTEGER PRIMARY KEY NOT NULL UNIQUE,
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
    Estado ENUM("Permitido", "Restringido") NOT NULL,
    IdEmpresa INTEGER NOT NULL,
    haSalido BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (IdEmpresa) REFERENCES Empresa(IdEmpresa)
);

CREATE TABLE IF NOT EXISTS Anotaciones (
    IdAnotacion INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Documento INTEGER NOT NULL,
    Tipo ENUM("Restricción", "Levantamiento", "Advertencia"),
    Mensaje VARCHAR(500),
    Fecha DATETIME NOT NULL,
    FOREIGN KEY (Documento) REFERENCES Persona(Documento)
);

CREATE TABLE IF NOT EXISTS Registro (
    IdRegistro INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Documento INTEGER NOT NULL,
    Fecha DATETIME NOT NULL,
    DocUser INTEGER NOT NULL,
    IdAnotacion INTEGER,
    TipoRegistro ENUM("Salida", "Entrada") NOT NULL,
    PlacaVehiculo CHAR(7),
    FOREIGN KEY (Documento) REFERENCES Persona(Documento),
    FOREIGN KEY (DocUser) REFERENCES Usuarios(Documento),
    FOREIGN KEY (IdAnotacion) REFERENCES Anotaciones(IdAnotacion)
);

CREATE TABLE IF NOT EXISTS Log (
    IdLog INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Fecha DATETIME NOT NULL,
    Observacion VARCHAR(500) NOT NULL,
    DocUser INTEGER,
    FOREIGN KEY (DocUser) REFERENCES Usuarios(Documento)
);

INSERT INTO `TipoUsuario`(`Nombre`) VALUES
("SuperUsuario"),
("Supervisor"),
("Guarda"),
("Funcionario");

/*
CREATE TABLE IF NOT EXISTS Empresa (
    IdEmpresa INTEGER PRIMARY KEY NOT NULL UNIQUE,
    Nombre VARCHAR(110) UNIQUE
); */
INSERT INTO `Empresa`(`Nombre`) VALUES
("Campus"),
("Seguridad")

INSERT INTO `Usuarios`(`Documento`,`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
(1020306598,"juanito","123",TRUE,1,1);

/* INSERT INTO `Usuarios`(`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
("juanito","123",TRUE,1,NULL); */

/* DELETE FROM `Usuarios`;

/* UPDATE `Usuarios` SET `Activo` = FALSE WHERE `IdUsuario`= ?; */

SELECT * FROM Empresa WHERE Empresa.IdEmpresa = 1;

SELECT *
    FROM Usuarios u
    JOIN TipoUsuario t ON u.IdTipoUsuario = t.IdTipo
    WHERE t.Nombre = 'Supervisor';

SELECT u.*, `Empresa`.`Nombre` as NombreEmpresa
FROM Usuarios u
JOIN TipoUsuario t ON u.IdTipoUsuario = t.IdTipo
JOIN `Empresa` ON `Empresa`.`IdEmpresa` = u.`IdEmpresa`
WHERE t.Nombre = 'Funcionario' ;

SELECT U.*, E.Nombre FROM `Usuarios` U JOIN `Empresa` E ON `E`.`IdEmpresa` = `U`.`IdEmpresa`;

/*
SELECT U.Nombre, Documento, E.Nombre FROM `Usuarios` U
            JOIN `Empresa` E
            ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
            WHERE U.IdTipoUsuario = 4 AND u.Documento = ? ; 
*/

/* UPDATE `Persona` SET `Estado` = "Permitido" WHERE `Documento` = ?; */

/*INSERT INTO `Empresa` VALUES 
(?,TRUE);
/*
CREATE TABLE IF NOT EXISTS Empresa (
    IdEmpresa INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Nombre VARCHAR(110) UNIQUE
); */