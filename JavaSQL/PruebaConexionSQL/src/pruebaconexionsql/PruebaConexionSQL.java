/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaconexionsql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pjarana
 */
public class PruebaConexionSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ResultSet res=null;
        Conexion cx=null;
        Statement sentencia=null;
        String consulta="Select Numero " +
            "from ApuestasNumeros as an " +
            "inner join Apuestas as a " +
            "on an.ID_Apuestas=a.ID " +
            "inner join Sorteos as s " +
            "on s.CombinacionGanadora=a.ID " +
            "where a.Tipo='G' and s.Fecha=(select top 1 Fecha from Sorteos)";
        try
        {
               cx=new Conexion("jdbc:sqlserver://localhost","pepito","qq");
               sentencia=cx.getConnection().createStatement();
               res= sentencia.executeQuery(consulta);
               System.out.println("Combinación Ganadora: ");
                while(res.next())
                {
                    System.out.print(res.getInt("Numero")+" ");
                }
                cx.getConnection().close();
        }catch(SQLException e)
        {
            System.out.println(e);
        }
       
        
    }
    
}
