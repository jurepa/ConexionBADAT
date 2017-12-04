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
        String consultaAviones="SELECT Matricula, Nombre, ID_Fabricante, Modelo, Fecha_Fabricacion, Fecha_Entrada,Filas,Asientos_x_Fila,Autonomia,Activo "
                + "FROM AS_Aviones";
        String insert="INSERT INTO AS_Incidencias (Avion,Latitud,Longitud,Descripcion,Tipo) VALUES(?,?,?,?,?)";
        String execute="EXECUTE dbo.anularAvion  ?";
        Avion a=null;
        Incidencia i=null;
        try 
        {
            Statement sentencia=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            PreparedStatement sentenciaInsert=cx.getConnection().prepareStatement(insert);
            CallableStatement sentenciaExecute=cx.getConnection().prepareCall(execute);
            Statement sentenciaAviones=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            ResultSet rsAviones=sentenciaAviones.executeQuery(consultaAviones);
            ResultSet rsActualizaciones=sentencia.executeQuery(consulta);
            while(rsActualizaciones.next()) //Recorremos la tabla de actualizaciones
            {
                i=new Incidencia(rsActualizaciones.getString("MatriculaAvion"),
                        rsActualizaciones.getBigDecimal("Latitud"),
                        rsActualizaciones.getBigDecimal("Longitud"), 
                        rsActualizaciones.getString("Descripcion"),
                        rsActualizaciones.getString("Tipo"));
                //Si el nombre de avión, fabricante y modelo no son nulos, insertamos
                if(rsActualizaciones.getString("NombreAvion")!=null && rsActualizaciones.getString("Fabricante")!=null && rsActualizaciones.getString("Modelo")!=null) 
                {
                    a=new Avion(rsActualizaciones.getString("MatriculaAvion"),//Insertamos el avión
                            rsActualizaciones.getString("NombreAvion"),
                            rsActualizaciones.getString("Fabricante"), 
                            rsActualizaciones.getString("Modelo"),
                            rsActualizaciones.getTimestamp("Fecha_Entrada"), //cambio de sitio la fecha de entrada y la de fabricacion por el problema del check
                            rsActualizaciones.getTimestamp("Fecha_Fabricacion"),
                            rsActualizaciones.getInt("Filas"),
                            rsActualizaciones.getInt("Asientos_x_Fila"),
                            rsActualizaciones.getInt("Autonomia"));
                    insertAvion(cx, a,rsAviones);
                }
                //Si el avión ha tenido un accidente que no le permite volar más
                if(rsActualizaciones.getBoolean("AccidenteDefinitivo"))
                {
                    darDeBajaAvion(cx, rsActualizaciones.getString("MatriculaAvion"),sentenciaExecute); //Damos de baja el avión
                }
                //Por cada fila de la tabla actualizaciones insertamos en la tabla incidencias
                insertIncidencia(cx, i,sentenciaInsert);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    /*
    Descripción: Este méetodo inserta un avión mediante un ResultSet actualizable en la tabla AS_Aviones
    Precondiciones:No hay
    Entradas: Un objeto conexion, un objeto avion y un objeto ResultSet
    Salidas: No hay
    Postcondiciones: No hay
    */
    public void insertAvion(Conexion cx,Avion a, ResultSet rsAviones)
    {
        
        int idFabricante=buscarIdFabricante(cx, a.getFabricante()); //Buscamos el id del fabricante
        try 
        {   //Insertamos en la tabla AS_Aviones con un resultSet actualizable            
            rsAviones.moveToInsertRow();
            rsAviones.updateString("Matricula",a.getMatriculaAvion());
            rsAviones.updateString("Nombre", a.getNombre());
            rsAviones.updateInt("ID_Fabricante", idFabricante);
            rsAviones.updateString("Modelo", a.getModelo());
            rsAviones.updateTimestamp("Fecha_Fabricacion", a.getFechaEntrada());
            rsAviones.updateTimestamp("Fecha_Entrada", a.getFechaFabricacion());
            rsAviones.updateInt("Filas", a.getFilas());
            rsAviones.updateInt("Asientos_x_Fila", a.getAsientosXFila());
            rsAviones.updateInt("Autonomia", a.getAutonomia());
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
    Entradas: Un objeto conexion, una cadena y un CallableStatement
    Salidas: No hay
    Postcondiciones: No hay
    */
    public void darDeBajaAvion(Conexion cx, String matricula,CallableStatement sentencia)
    {
        try 
        {
            sentencia.setString(1,matricula);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    /*
    Descripción: Este método se encarga de realizar los insert en la tabla Incidencias mediante sentencias preparadas
    Precondiciones: No hay
    Entradas: Un objeto conexion, un objeto incidencia y un PreparedStatement
    Salidas: No hay
    Postcondiciones: No hay
    */
    public void insertIncidencia(Conexion cx,Incidencia i,PreparedStatement sentencia)
    {
        
        try 
        {          
            sentencia.setString(1,i.getMatriculaAvion());
            sentencia.setBigDecimal(2, i.getLatitud());
            sentencia.setBigDecimal(3, i.getLongitud());
            sentencia.setString(4, i.getDescripcion());
            sentencia.setString(5, i.getTipo());
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
