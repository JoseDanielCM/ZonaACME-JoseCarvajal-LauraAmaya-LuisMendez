/* levantamiento, auditoria de empleados, */


/* INACTIVAR PERSONAS AL INACTIVAR EMPRESA */ 
DELIMITER $$

CREATE TRIGGER inactivacionEmpresa
AFTER UPDATE ON Empresa
FOR EACH ROW
BEGIN
    UPDATE Persona SET Activo = FALSE WHERE IdEmpresa = OLD.IdEmpresa;
END $$

DELIMITER ;

INSERT INTO Anotaciones(Documento,DocUser,Tipo,Mensaje,Fecha) VALUES (1102359291,1020306598,"Levantamiento","persona restringida",NOW());

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

INSERT INTO Anotaciones(Documento,DocUser,Tipo,Mensaje,Fecha) VALUES (1102359291,1020306598,"Registro","registrar persona manualmente",NOW());

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

INSERT INTO `Registro`(`Documento`,`Fecha`,`DocUser`,`IdAnotacion`,`TipoRegistro`,`PlacaVehiculo`) VALUES
(1102359291, "2024-12-13 08:55:46.00", 1102359888, NULL, "Salida", NULL),
(1102359291, "2024-12-13 10:55:46.00", 1102359888, NULL, "Entrada", NULL),
(1112223334, "2024-12-13 10:55:46.02", 1102359888, NULL, "Salida", NULL),
(1231231231, "2024-12-13 11:55:46.00", 1102359888, NULL, "Salida", NULL);

INSERT INTO Anotaciones(Documento,DocUser,Tipo,Mensaje,Fecha) VALUES (1102359291,1020306598,"Levantamiento","persona restringida",NOW());
