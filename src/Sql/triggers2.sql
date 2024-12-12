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
DROP TRIGGER restringirPersona;

/* AL REALIZAR ANOTACION DE LEVANTAMIENTO CAMBIAR ESTADO DE PERSONA */ 
DELIMITER $$
CREATE TRIGGER levantarRestriccion
AFTER INSERT ON Anotaciones
FOR EACH ROW
BEGIN
    IF NEW.Tipo = "levantamiento" THEN
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

DROP TRIGGER registroSalidaManual;