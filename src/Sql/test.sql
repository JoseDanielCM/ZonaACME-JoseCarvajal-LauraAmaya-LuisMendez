SELECT Persona.Documento, Persona.Nombre, Persona.Estado, Persona.IdEmpresa,
       Anotaciones.IdAnotacion, Anotaciones.Tipo, Anotaciones.Mensaje, Anotaciones.Fecha
FROM Persona
JOIN Anotaciones ON Anotaciones.Documento = Persona.Documento
WHERE Persona.Documento = 1102359291;