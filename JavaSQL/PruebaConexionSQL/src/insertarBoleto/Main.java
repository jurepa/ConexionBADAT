/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertarBoleto;

import java.sql.SQLException;



/**
 *
 * @author pjarana
 */
public class Main 
{
    public static void main (String[]args)
    {
        Gestora gestora=new Gestora();
        Conexion cx;
        int []numero=gestora.leerNumeros();
        try 
        {
            cx=new Conexion("jdbc:sqlserver://localhost","pepito","qq");
            gestora.introducirApuesta(numero, cx);
            gestora.mostrarApuesta(cx);
            cx.getConnection().close();
        } catch (SQLException ex) 
        {
            System.out.println(ex);
        } 
    }
}
