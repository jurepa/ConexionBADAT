/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamenLastYear;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pjarana
 */
public class Main {
    
    public static void main(String[]args)
    {
        Conexion cx;
        Gestora gestora=new Gestora();    
        try 
        {
            cx=new Conexion("jdbc:sqlserver://localhost","pepito","qq");
            gestora.realizarActualizaciones(cx);
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
