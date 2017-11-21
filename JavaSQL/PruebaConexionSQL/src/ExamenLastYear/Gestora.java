/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLastYear;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

/**
 *
 * @author pjarana
 */
public class Gestora 
{
    public void realizarActualizaciones(Conexion cx)
    {
        String consulta="Select Fecha,Temperatura,Peso,CodigoMascota,Raza,Especie,FechaNacimiento,FechaFallecimiento,CodigoPropietario,Enfermedad from BI_Actualizaciones";
        String consultaMascotas="Select Codigo,Raza,Especie,FechaNacimiento,FechaFallecimiento,Alias,CodigoPropietario from BI_Mascotas";
        try 
        {
            Statement sentencia=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            Statement sentenciaInsertMascotas=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultadoTablaMascotas=sentencia.executeQuery(consultaMascotas);
            ResultSet resultadoConsultaActualizaciones=sentencia.executeQuery(consulta);
            while(resultadoConsultaActualizaciones.next())//Recorremos la tabla actualizaciones
            {
                //Realizamos los inserts en Mascotas, en caso de que haya que hacerlos
                if(resultadoConsultaActualizaciones.getString("Raza")!=null&&resultadoConsultaActualizaciones.getString("Especie")!=null)
                {
                    resultadoTablaMascotas.moveToInsertRow();
                    resultadoTablaMascotas.updateString("Codigo", resultadoConsultaActualizaciones.getString("CodigoMascota"));
                    resultadoTablaMascotas.updateString("Raza", resultadoConsultaActualizaciones.getString("Raza"));
                    resultadoTablaMascotas.updateString("Especie", resultadoConsultaActualizaciones.getString("Raza"));
                    resultadoTablaMascotas.updateTimestamp("FechaNacimiento", resultadoConsultaActualizaciones.getTimestamp("FechaNacimiento"));
                    resultadoTablaMascotas.updateString("Alias", resultadoConsultaActualizaciones.getString("Alias"));
                    resultadoTablaMascotas.updateString("CodigoPropietario", resultadoConsultaActualizaciones.getString("CodigoPropietario"));
                    if(resultadoConsultaActualizaciones.getString("Enfermedad")!=null)
                    {
                        procedimientoMascotasEnfermedades(cx, resultadoConsultaActualizaciones.getString("Enfermedad"), resultadoConsultaActualizaciones.getString("CodigoMascota"), resultadoConsultaActualizaciones.getTimestamp("Fecha"));
                    }
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Gestora.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
    public void procedimientoMascotasEnfermedades(Conexion cx, String nombreEnfermedad,String codigoMascota,java.sql.Timestamp fechaDiagnostico)
    {
        String execute="EXECUTE dbo.insertMascotasEnfermedades  ?,?,?";
        try 
        {
            CallableStatement sentencia=cx.getConnection().prepareCall(execute);
            sentencia.setTimestamp(1, fechaDiagnostico);
            sentencia.setString(2, nombreEnfermedad);
            sentencia.setString(3, codigoMascota);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
