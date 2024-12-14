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

CREATE TABLE IF NOT EXISTS Vehiculo (
    Placa CHAR(6) PRIMARY KEY NOT NULL UNIQUE,
    Estado ENUM("Permitido", "Restringido","Inactivo") NOT NULL,
    haSalido BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS Persona (
    Documento INTEGER PRIMARY KEY NOT NULL UNIQUE,
    Nombre VARCHAR(100) NOT NULL,
    Activo BOOLEAN NOT NULL DEFAULT TRUE,
    Tipo ENUM("Trabajador", "Invitado") NOT NULL,
    Estado ENUM("Permitido", "Restringido") NOT NULL,
    IdEmpresa INTEGER NOT NULL,
    haSalido BOOLEAN DEFAULT FALSE,
    PlacaVehiculo CHAR(6),
    FOREIGN KEY (IdEmpresa) REFERENCES Empresa(IdEmpresa),
    FOREIGN KEY (PlacaVehiculo) REFERENCES Vehiculo(Placa)
);

CREATE TABLE IF NOT EXISTS Anotaciones (
    IdAnotacion INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Documento INTEGER NOT NULL,
    DocUser INTEGER NOT NULL,
    Tipo ENUM("Restricción", "Levantamiento", "Registro"),
    Mensaje VARCHAR(500),
    Fecha DATETIME NOT NULL,
    FOREIGN KEY (Documento) REFERENCES Persona(Documento),
    FOREIGN KEY (DocUser) REFERENCES Usuarios(Documento)
);

CREATE TABLE IF NOT EXISTS Registro (
    IdRegistro INTEGER PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
    Documento INTEGER NOT NULL,
    Fecha DATETIME NOT NULL,
    DocUser INTEGER NOT NULL,
    IdAnotacion INTEGER,
    TipoRegistro ENUM("Salida", "Entrada") NOT NULL,
    PlacaVehiculo CHAR(6),
    FOREIGN KEY (Documento) REFERENCES Persona(Documento),
    FOREIGN KEY (DocUser) REFERENCES Usuarios(Documento),
    FOREIGN KEY (IdAnotacion) REFERENCES Anotaciones(IdAnotacion),
    FOREIGN KEY (PlacaVehiculo) REFERENCES Vehiculo(Placa)
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

INSERT INTO `Empresa`(`IdEmpresa`,`Nombre`) VALUES
(1112223331,"Campus"),
(1234567890,"Seguridad")

INSERT INTO `Usuarios`(`Documento`,`Nombre`,`Contrasena`,`Activo`,`IdTipoUsuario`,`IdEmpresa`) VALUES
(1020306598,"juanito","123",TRUE,1,1112223331),
(1212121232,"jj","gato",TRUE,3,1234567890),
(1102359888,"Luis","gg",TRUE,3,1234567890),
(1102359295,"Jose","totoro",TRUE,4,1112223331),
(1102359999,"Laura","1234",TRUE,2,1112223331);

INSERT INTO `Vehiculo`(`Placa`, `Estado`,`haSalido`) VALUES
("GPR895","Permitido",FALSE),
("JLO777","Permitido",FALSE),
("ABA555","Permitido",FALSE);

INSERT INTO `Persona` VALUES
(1102359291,"Lili",TRUE,"Trabajador","Permitido",1112223331,FALSE,"GPR895"),
(1515151515,"Marco",TRUE,"Trabajador","Permitido",1112223331,FALSE,"GPR895"),
(1231231231,"Lucas",TRUE,"Invitado","Permitido",1234567890,FALSE,"GPR895"),
(1112223334,"Pepe",TRUE,"Invitado","Permitido",1234567890,FALSE,NULL);


INSERT INTO `Registro`(`Documento`,`Fecha`,`DocUser`,`IdAnotacion`,`TipoRegistro`,`PlacaVehiculo`) VALUES
(1102359291, "2024-12-13 15:29:46.00", 1102359888, NULL, "Salida", NULL),
(1102359291, "2024-12-13 15:30:46.00", 1102359888, NULL, "Entrada", NULL);


INSERT INTO `Registro`(`Documento`,`Fecha`,`DocUser`,`IdAnotacion`,`TipoRegistro`,`PlacaVehiculo`) VALUES
(1102359291, "2024-12-13 15:38:46.00", 1102359888, NULL, "Salida", NULL);

SELECT Usuarios.*, TipoUsuario.`Nombre` as NombreTipo, Empresa.`IdEmpresa`, Empresa.`Nombre` as NombreEmpresa FROM Usuarios
JOIN TipoUsuario ON TipoUsuario.`IdTipo` = Usuarios.`IdTipoUsuario`
JOIN Empresa ON Empresa.`IdEmpresa` = Usuarios.`IdEmpresa`
WHERE Usuarios.`Documento`= 1020306598 AND Usuarios.`Contrasena` = '123';

SELECT Usuarios.*, TipoUsuario.`Nombre` as NombreTipo, Empresa.`IdEmpresa`, Empresa.`Nombre` as NombreEmpresa FROM Usuarios
JOIN TipoUsuario ON TipoUsuario.`IdTipo` = Usuarios.`IdTipoUsuario`
JOIN Empresa ON Empresa.`IdEmpresa` = Usuarios.`IdEmpresa`
WHERE Usuarios.`Documento`= 1020306598 AND Usuarios.`Contrasena` = '1020306598';

SELECT Usuarios.*, TipoUsuario.`Nombre` as NombreTipo, Empresa.`IdEmpresa`, Empresa.`Nombre` as NombreEmpresa FROM Usuarios
JOIN TipoUsuario ON TipoUsuario.`IdTipo` = Usuarios.`IdTipoUsuario`
JOIN Empresa ON Empresa.`IdEmpresa` = Usuarios.`IdEmpresa`
WHERE Usuarios.`Documento`= 1020306598 AND Usuarios.`Contrasena` = '123';

SELECT Usuarios.*, TipoUsuario.`Nombre` as NombreTipo, Empresa.`IdEmpresa`, Empresa.`Nombre` as NombreEmpresa FROM Usuarios
JOIN TipoUsuario ON TipoUsuario.`IdTipo` = Usuarios.`IdTipoUsuario`
JOIN Empresa ON Empresa.`IdEmpresa` = Usuarios.`IdEmpresa`
WHERE Usuarios.`Documento`= 1102359999 AND Usuarios.`Contrasena` = '1234';

UPDATE `Persona` SET `Estado` = "Restringido" WHERE `Documento` = 1102359291;

SELECT U.`Documento`, U.Nombre as Nombre, U.`Contrasena`, U.`Activo`, Documento, E.Nombre as NombreEmpresa, E.IdEmpresa FROM `Usuarios` U
    JOIN `Empresa` E
    ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
    WHERE U.IdTipoUsuario = 4 AND U.Documento = 1102359295 ;

    UPDATE `Usuarios` SET `Activo` = FALSE WHERE `Documento`= 1102359295;

    SELECT U.`Documento`, U.Nombre as Nombre, U.`Contrasena`, U.`Activo`, Documento, E.Nombre as NombreEmpresa, E.IdEmpresa FROM `Usuarios` U
JOIN `Empresa` E
ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
WHERE U.IdTipoUsuario = 3 AND U.Documento = 1102359888 ;

SELECT U.`Documento`, U.Nombre, Documento, E.Nombre, E.IdEmpresa FROM `Usuarios` U
    JOIN `Empresa` E
    ON `E`.`IdEmpresa` = `U`.`IdEmpresa`
    WHERE U.IdTipoUsuario = 4 AND U.Documento = 1102359295 ;

UPDATE `Persona` SET `Nombre` = ?, `PlacaVehiculo` = ?  WHERE `Documento` = ?;

UPDATE `Vehiculo` SET `Placa` = 'PPP313' WHERE `Placa` = 'JLO777';

SHOW CREATE TABLE Persona;

ALTER TABLE Persona DROP FOREIGN KEY Persona_ibfk_2; 

ALTER TABLE Persona
ADD CONSTRAINT Persona_ibfk_2
FOREIGN KEY (PlacaVehiculo) REFERENCES Vehiculo(Placa)
ON UPDATE CASCADE;

INSERT INTO `Registro`() VALUES
(1111212121,NOW(),1102359888,NULL,"Entrada",NULL);

INSERT INTO `Registro`(`Documento`,`Fecha`,`DocUser`,`IdAnotacion`,`TipoRegistro`,`PlacaVehiculo`) VALUES
(1102359291, "2024-12-13 08:55:46.00", 1102359888, NULL, "Salida", NULL),
(1102359291, "2024-12-13 10:55:46.00", 1102359888, NULL, "Entrada", NULL),
(1112223334, "2024-12-13 10:55:46.02", 1102359888, NULL, "Salida", NULL),
(1231231231, "2024-12-13 11:55:46.00", 1102359888, NULL, "Salida", NULL);