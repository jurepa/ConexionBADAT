/*
Descripción: Este procedimiento realiza una inserción en la tabla mascotasEnfermedades
Precondiciones: La mascota y la enfermedad introducida en conjunto no pueden estar repetidas en la base de datos
Entradas: Una fecha date, un varchar(30) y un codigo char(5)
Salidas: No hay
Postcondiciones: No hay
E/S: No hay
*/
ALTER PROCEDURE insertMascotasEnfermedades @Fecha DATE, @nombreEnfermedad VARCHAR(30),@CodigoMascota CHAR(5) 
AS
BEGIN
	IF EXISTS(SELECT ID FROM BI_Enfermedades WHERE Nombre=@nombreEnfermedad)
	BEGIN
		IF EXISTS(SELECT Codigo FROM BI_Mascotas WHERE Codigo=@CodigoMascota)
		BEGIN
			INSERT INTO BI_Mascotas_Enfermedades (IDEnfermedad,Mascota,FechaInicio) VALUES((SELECT ID FROM BI_Enfermedades WHERE @nombreEnfermedad=Nombre),@CodigoMascota,@Fecha)
		END
		ELSE
		BEGIN
			PRINT'No existe ese codigo'
		END
	END
	ELSE
	BEGIN
		PRINT 'No existe esa enfermedad'
	END
END
GO
DECLARE @FECHA DATE
SET @Fecha=CURRENT_TIMESTAMP
EXECUTE dbo.insertMascotasEnfermedades @Fecha,'Borreliosis','GH003'
select * from BI_Actualizaciones
Select Codigo,Raza,Especie,FechaNacimiento,FechaFallecimiento,Alias,CodigoPropietario from BI_Mascotas
 