/* INACTIVAR PERSONAS AL INACTIVAR EMPRESA */ 
DELIMITER $$

CREATE TRIGGER inactivacionEmpresa
AFTER UPDATE ON Empresa
FOR EACH ROW
BEGIN
    UPDATE Persona SET Activo = FALSE WHERE `IdEmpresa` = NEW.`IdEmpresa`;
END $$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER inactivacionUsuariosEmpresa
AFTER UPDATE ON Empresa
FOR EACH ROW
BEGIN
    UPDATE usuarios SET `Activo` = FALSE WHERE `IdEmpresa` = NEW.`IdEmpresa`;
END $$

DELIMITER ;

/* AL REALIZAR ANOTACION DE RESTRICCION CAMBIAR ESTADO DE PERSONA */ 
DELIMITER $$
CREATE TRIGGER restringirPersona
AFTER INSERT ON Anotaciones
FOR EACH ROW
BEGIN
    IF NEW.Tipo = "Restricción" THEN
        UPDATE Persona SET Estado = "Restringido" WHERE Documento = NEW.Documento;
    END IF;
END $$

DELIMITER ;
/* DROP TRIGGER restringirPersona;

/* AL REALIZAR ANOTACION DE LEVANTAMIENTO CAMBIAR ESTADO DE PERSONA */ 
DELIMITER $$
CREATE TRIGGER levantarRestriccion
AFTER INSERT ON Anotaciones
FOR EACH ROW
BEGIN
    IF NEW.Tipo = "Levantamiento" THEN
        UPDATE Persona SET Estado = "Permitido" WHERE Documento = NEW.Documento;
    END IF;
END $$

DELIMITER ;

/* Registro manual */ 

DELIMITER $$
CREATE TRIGGER registroSalidaManual
AFTER INSERT ON Anotaciones
FOR EACH ROW
BEGIN
  IF NEW.Tipo = "Registro" THEN
    INSERT INTO Registro (Documento, Fecha, DocUser, IdAnotacion, TipoRegistro, PlacaVehiculo )
    VALUES (
      NEW.Documento,
      NEW.fecha,
      NEW.DocUser,
      NEW.idAnotacion,
      "Salida",
      NULL
    );
  END IF;
END $$
DELIMITER ;

/* DROP TRIGGER registroSalidaManual; */

DELIMITER $$
CREATE TRIGGER cambiarEstancia
AFTER INSERT ON Registro
FOR EACH ROW
BEGIN
    IF NEW.TipoRegistro = "Entrada" THEN
        UPDATE Persona SET `haSalido` = FALSE WHERE Documento = NEW.Documento;
    ELSEIF NEW.TipoRegistro = "Salida" THEN
        UPDATE Persona SET `haSalido` = TRUE WHERE Documento = NEW.Documento;
    END IF;
END $$
DELIMITER ;

/* DROP TRIGGER cambiarEstancia; */

INSERT INTO registro() VALUES()

INSERT INTO Registro(`Documento`,`Fecha`,`DocUser`,`IdAnotacion`,`TipoRegistro`,`PlacaVehiculo`) VALUES
(1102359291, "2024-12-15 06:35:00", 1112221121, NULL, "Salida", "ABA555"),
(1102359291, "2024-12-15 6:35:30", 1212121232, NULL, "Entrada", "ABA555"),
(1112223334, "2024-12-15 6:30:00", 1112221121, NULL, "Salida", "ABA555"),
(1515151515, "2024-12-15 5:55:46", 1212121232, NULL, "Salida", "ABA555");
