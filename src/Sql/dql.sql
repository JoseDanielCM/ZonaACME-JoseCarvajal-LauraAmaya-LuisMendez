SELECT `Persona`.`Documento`,`Persona`.`Nombre`,`Persona`.`Estado`,`Persona`.`IdEmpresa`,`Anotaciones`.`IdAnotacion`,`Anotaciones`.`Tipo`,`Anotaciones`.`Mensaje`,`Anotaciones`.`Fecha` FROM `Persona`
JOIN `Anotaciones` ON `Anotaciones`.`Documento` = `Persona`.`Documento`
where `Persona`.`Documento` =  1102359291;

SELECT Usuarios.*, TipoUsuario.`Nombre` as NombreTipo, Empresa.`IdEmpresa`, Empresa.`Nombre` as NombreEmpresa FROM Usuarios 
JOIN TipoUsuario ON TipoUsuario.`IdTipo` = Usuarios.`IdTipoUsuario`
JOIN Empresa ON Empresa.`IdEmpresa` = Usuarios.`IdEmpresa`
WHERE Usuarios.`Documento`= 1 AND Usuarios.`Contrasena` = "1";

SELECT usuarios.*, tipousuario.`Nombre` FROM usuarios JOIN tipousuario  ON tipousuario.`IdTipo` = usuarios.`IdTipoUsuario`   LIMIT 100