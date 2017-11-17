/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertarBoleto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pjarana
 */
public class Gestora 
{
    /*
    Descripción: Lee los 6 números que quiere insertar el usuario en un parámetro
    Prototipo: public int[]leerNumeros()
    Precondiciones:No hay
    Entradas: No hay
    Salidas: Un array de enteros
    Postcondiciones: El array no estará vacío y contendrá números del 1 al 49
    E/S: No hay
    */
    public int [] leerNumeros()
    {
        int []numero=new int[6];
        int posicion;
        Scanner teclado=new Scanner(System.in);
        for(int i=0;i<numero.length;i++)
        {
            posicion=i+1;
            do
            {
                System.out.println("Introduce el número "+posicion+" del boleto");
                numero[i]=teclado.nextInt();
            }while(numero[i]<1||numero[i]>49);
        }
        return numero;
    }
    
    /*
    Descripción: Este método introduce la apuesta en la BBDD
    Prototipo: public void introducirApuesta(int[]numeros,Conexion cx)
    Precondiciones: El array debe ser de tamaño 6 y no estar vacío
    Entradas: Un array de enteros y un objeto conexion
    Salidas: No hay
    Postcondiciones: No hay
    E/S: No hay
    */
    public void introducirApuesta(int[]numeros, Conexion cx)
    {
        String execute="EXECUTE dbo.GrabaSencilla  ?,?,?,?,?,?,?,20.0";
        GregorianCalendar fecha=new GregorianCalendar(2038,4,22,20,0,0);//yyyy,[m]m,[d]d,[h]h,[m]m,[s]s        
        java.sql.Timestamp fechaSorteo=new java.sql.Timestamp(fecha.getTimeInMillis());
        try 
        {
            CallableStatement sentencia=cx.getConnection().prepareCall(execute);
            sentencia.setTimestamp(1, fechaSorteo);
            sentencia.setInt(2,numeros[0]);
            sentencia.setInt(3,numeros[1]);
            sentencia.setInt(4,numeros[2]);
            sentencia.setInt(5,numeros[3]);
            sentencia.setInt(6,numeros[4]);
            sentencia.setInt(7,numeros[5]);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            //Logger.getLogger(Gestora.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
    /*
    Descripción: Este método imprime la última apuesta en pantalla
    Prototipo: public void mostrarApuesta(Conexion cx)
    Precondiciones: No hay
    Entradas: Un objeto conexion
    Salidas: No hay
    Postcondiciones: No hay
    E/S: No hay
    */
    public void mostrarApuesta(Conexion cx)
    {
        String consulta="SELECT B.ID, A.Tipo, AN.Numero\n" +
                        "FROM Boletos AS B\n" +
                        "INNER JOIN Apuestas AS A\n" +
                        "ON B.ID=A.ID_Boleto\n" +
                        "INNER JOIN ApuestasNumeros AS AN\n" +
                        "ON A.ID=AN.ID_Apuestas\n" +
                        "WHERE B.ID=(SELECT MAX(ID) FROM BOLETOS) AND A.Tipo='S'";
        try 
        {
            Statement sentencia=cx.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
            ResultSet res=sentencia.executeQuery(consulta);
            System.out.println("Boleto introducido: ");
            while(res.next())
            {
                System.out.println("ID: "+res.getInt("ID")+", Numero: "+ res.getInt("Numero")+", Tipo apuesta: "+ res.getString("Tipo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gestora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
