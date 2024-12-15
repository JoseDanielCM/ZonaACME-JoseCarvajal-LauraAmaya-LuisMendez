SELECT Persona.Documento, Persona.Nombre, Persona.Estado, Persona.IdEmpresa,
       Anotaciones.IdAnotacion, Anotaciones.Tipo, Anotaciones.Mensaje, Anotaciones.Fecha
FROM Persona
JOIN Anotaciones ON Anotaciones.Documento = Persona.Documento
WHERE Persona.Documento = 1102359291;

SELECT `Persona`.*, e.`Nombre` FROM `Persona`
                    JOIN Empresa e ON e.`IdEmpresa` = `Persona`.`IdEmpresa`;

UPDATE `Vehiculo` SET `Placa` = 'ABA111' WHERE `Placa` = 'GPR895';

SELECT * FROM `persona` WHERE `PlacaVehiculo` = 'GPR895';

SELECT * FROM `vehiculo` WHERE `Placa` = 'GPR895';

/* SHOW CREATE TABLE `persona`; */

SELECT * FROM Usuarios WHERE Usuarios.IdTipoUsuario = 2;

SELECT `Usuarios`.*, empresa.`Nombre` as NombreEmpresa FROM Usuarios 
JOIN empresa ON empresa.`IdEmpresa` = `Usuarios`.`IdEmpresa`
WHERE Usuarios.IdTipoUsuario = 2;

SELECT Usuarios.`Activo` FROM Usuarios

INSERT INTO `Anotaciones`(`Documento`,`DocUser`,`Tipo`,`Mensaje`,`Fecha`) VALUES
(?,?,"Levantamiento","Remover restriccion a la persona",NOW());