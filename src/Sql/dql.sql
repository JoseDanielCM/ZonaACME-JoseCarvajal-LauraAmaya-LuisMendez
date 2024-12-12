SELECT `Persona`.`Documento`,`Persona`.`Nombre`,`Persona`.`Estado`,`Persona`.`IdEmpresa`,`Anotaciones`.`IdAnotacion`,`Anotaciones`.`Tipo`,`Anotaciones`.`Mensaje`,`Anotaciones`.`Fecha` FROM `Persona`
JOIN `Anotaciones` ON `Anotaciones`.`Documento` = `Persona`.`Documento`
where `Persona`.`Documento` =  1102359291;

SELECT usuarios.*, tipousuario.`Nombre` as NombreTipo, empresa.`IdEmpresa`, empresa.`Nombre` as NombreEmpresa FROM usuarios 
JOIN tipousuario ON tipousuario.`IdTipo` = usuarios.`IdTipoUsuario`
JOIN empresa ON empresa.`IdEmpresa` = usuarios.`IdEmpresa`
WHERE usuarios.`Documento`= 1 AND usuarios.`Contrasena` = "1";