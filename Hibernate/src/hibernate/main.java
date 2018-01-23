/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;


import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



/**
 *
 * @author pjarana
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SessionFactory sesionBeta= HibernateUtil.getSessionFactory();
        Session sesion=sesionBeta.openSession();
        Query q=sesion.createQuery("from ASAviones");
        List<ASAviones>aviones=q.list();
        ASAviones a;
        while(aviones.hasNext())
        {
             a=aviones.next();
        }
        sesion.close();
    }
    
}
