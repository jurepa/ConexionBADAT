/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJaranaExamen1Ev;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pjarana
 * ANOTACIONES: Usuario: pepito Pass: qq                       !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class GestoraActualizaciones {
    /*
    Descripción: Método que se encarga de recorrer la tabla actualizaciones y realizar las actualizaciones correspondientes
    Precondiciones: No hay
    Entradas: Un objeto conexion
    Salidas: No hay
    Postcondiciones: No hay
    */
    public void realizarActualizaciones(Conexion cx)
    {
        String consulta="SELECT MatriculaAvion, Latitud, Longitud, Descripcion, "
                + "Tipo, AccidenteDefinitivo, NombreAvion, Fabricante, Modelo, "
                + "Fecha_Fabricacion, Fecha_Entrada, Filas, Asientos_x_Fila, Autonomia "
                + "FROM EX_Actualizaciones";
        try 
        {
            Statement sentencia=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            ResultSet rsActualizaciones=sentencia.executeQuery(consulta);
            while(rsActualizaciones.next()) //Recorremos la tabla de actualizaciones
            {
                //Si el nombre de avión, fabricante y modelo no son nulos, insertamos
                if(rsActualizaciones.getString("NombreAvion")!=null && rsActualizaciones.getString("Fabricante")!=null && rsActualizaciones.getString("Modelo")!=null) 
                {
                    insertAvion(cx, rsActualizaciones.getString("MatriculaAvion"),//Insertamos el avión
                            rsActualizaciones.getString("NombreAvion"),
                            rsActualizaciones.getString("Fabricante"), 
                            rsActualizaciones.getString("Modelo"),
                            rsActualizaciones.getTimestamp("Fecha_Entrada"), //cambio de sitio la fecha de entrada y la de fabricacion por el problema del check
                            rsActualizaciones.getTimestamp("Fecha_Fabricacion"),
                            rsActualizaciones.getInt("Filas"),
                            rsActualizaciones.getInt("Asientos_x_Fila"),
                            rsActualizaciones.getInt("Autonomia"));
                }
                //Si el avión ha tenido un accidente que no le permite volar más
                if(rsActualizaciones.getBoolean("AccidenteDefinitivo"))
                {
                    darDeBajaAvion(cx, rsActualizaciones.getString("MatriculaAvion")); //Damos de baja el avión
                }
                //Por cada fila de la tabla actualizaciones insertamos en la tabla incidencias
                insertIncidencia(cx, rsActualizaciones.getString("MatriculaAvion"),
                        rsActualizaciones.getBigDecimal("Latitud"),
                        rsActualizaciones.getBigDecimal("Longitud"), 
                        rsActualizaciones.getString("Descripcion"),
                        rsActualizaciones.getString("Tipo"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    /*
    Descripción: Este méetodo inserta un avión mediante un ResultSet actualizable en la tabla AS_Aviones
    Precondiciones:No hay
    Entradas: Un objeto conexion, 3 cadenas, 3 enteros y 2 TimeStamp
    Salidas: No hay
    Postcondiciones: No hay
    */
    public void insertAvion(Conexion cx,String matricula, String nombre, String nombreFabricante, String modelo, java.sql.Timestamp fechaFabricacion,
                            java.sql.Timestamp fechaEntrada, int filas, int asientosPorFila, int autonomia)
    {
        String consultaAviones="SELECT Matricula, Nombre, ID_Fabricante, Modelo, Fecha_Fabricacion, Fecha_Entrada,Filas,Asientos_x_Fila,Autonomia,Activo "
                + "FROM AS_Aviones";
        int idFabricante=buscarIdFabricante(cx, nombreFabricante); //Buscamos el id del fabricante
        try 
        {   //Insertamos en la tabla AS_Aviones con un resultSet actualizable
            Statement sentencia=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            ResultSet rsAviones=sentencia.executeQuery(consultaAviones);
            rsAviones.moveToInsertRow();
            rsAviones.updateString("Matricula", matricula);
            rsAviones.updateString("Nombre", nombre);
            rsAviones.updateInt("ID_Fabricante", idFabricante);
            rsAviones.updateString("Modelo", modelo);
            rsAviones.updateTimestamp("Fecha_Fabricacion", fechaFabricacion);
            rsAviones.updateTimestamp("Fecha_Entrada", fechaEntrada);
            rsAviones.updateInt("Filas", filas);
            rsAviones.updateInt("Asientos_x_Fila", asientosPorFila);
            rsAviones.updateInt("Autonomia", autonomia);
            rsAviones.insertRow();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    /*
    *Descripcion:Este método busca el id de un fabricante
    Precondiciones: No hay
    Entradas: Un objeto conexion y una cadena
    Salidas: Un entero
    Postcondiciones: Devuelve 0 si ha ocurrido algun fallo o no ha encontrado el fabricante
    */
    public int buscarIdFabricante(Conexion cx, String nombreFabricante)
    {
        String consultaFabricantes="SELECT ID_Fabricante FROM AS_Fabricantes WHERE Nombre='"+nombreFabricante+"'";
        int id=0;
        try {
            Statement sentencia=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            ResultSet rsIDFab=sentencia.executeQuery(consultaFabricantes);
            while(rsIDFab.next())
            {
                id=rsIDFab.getInt("ID_Fabricante");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return id;
    }
    /*
    Descripción: Este método se encarga de ejecutar el procedimiento de dar de baja un avion en la base de datos
    Precondiciones: La matricula debe existir en la base de datos
    Entradas: Un objeto conexion y una cadena
    Salidas: No hay
    Postcondiciones: No hay
    */
    public void darDeBajaAvion(Conexion cx, String matricula)
    {
        String execute="EXECUTE dbo.anularAvion  ?";
        try 
        {
            CallableStatement sentencia=cx.getConnection().prepareCall(execute);
            sentencia.setString(1,matricula);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    /*
    Descripción: Este método se encarga de realizar los insert en la tabla Incidencias mediante sentencias preparadas
    Precondiciones: No hay
    Entradas: Un objeto conexion, 3 cadenas y 2 BigDecimal
    Salidas: No hay
    Postcondiciones: No hay
    */
    public void insertIncidencia(Conexion cx,String matricula,java.math.BigDecimal latitud,java.math.BigDecimal longitud,String descripcion,String tipo)
    {
        String insert="INSERT INTO AS_Incidencias (Avion,Latitud,Longitud,Descripcion,Tipo) VALUES(?,?,?,?,?)";
        try 
        {
            PreparedStatement sentencia=cx.getConnection().prepareStatement(insert);
            sentencia.setString(1,matricula);
            sentencia.setBigDecimal(2, latitud);
            sentencia.setBigDecimal(3, longitud);
            sentencia.setString(4, descripcion);
            sentencia.setString(5, tipo);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
