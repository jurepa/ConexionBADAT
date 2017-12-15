/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxActualizaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pjarana
 */
public class Conexion {
    
    private String sourceURL;
    private String user;
    private String password;
    private Connection conexionBadat;
    public Conexion()
    {
        this.sourceURL="";
        this.user="";
        this.password="";
    }
    public Conexion(String sourceURL, String user, String password)throws SQLException
    {
        this.sourceURL=sourceURL;
        this.user=user;
        this.password=password;
        this.conexionBadat= DriverManager.getConnection(this.sourceURL,this.user,this.password);
    }
    public Conexion (Conexion c)throws SQLException
    {
        this.sourceURL=c.sourceURL;
        this.user=c.user;
        this.password=c.password;
        this.conexionBadat= DriverManager.getConnection(this.sourceURL,this.user,this.password);
    }
    public Connection getConnection()
    {
        return this.conexionBadat;
    }
    
    
}
