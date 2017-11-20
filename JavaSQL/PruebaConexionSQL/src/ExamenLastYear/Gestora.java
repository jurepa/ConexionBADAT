/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLastYear;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pjarana
 */
public class Gestora 
{
    public void realizarActualizaciones(Conexion cx)
    {
        String consulta="Select * from BI_Actualizaciones";
        try 
        {
            Statement sentencia=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultado=sentencia.executeQuery(consulta);
            while(resultado.next())
            {
                
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Gestora.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex");
        }
    }
}
