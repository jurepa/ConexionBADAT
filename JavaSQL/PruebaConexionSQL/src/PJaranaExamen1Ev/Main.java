/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJaranaExamen1Ev;

import java.sql.SQLException;


/**
 *
 * @author pjarana
 * ANOTACIONES: Usuario: pepito Pass:qq                            !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class Main {
    
    public static void main(String[]args)
    {
        Conexion cx;
        GestoraActualizaciones gestora=new GestoraActualizaciones();
        try 
        {
            cx=new Conexion("jdbc:sqlserver://localhost","pepito","qq");
            gestora.realizarActualizaciones(cx);
            cx.getConnection().close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
    }
}
