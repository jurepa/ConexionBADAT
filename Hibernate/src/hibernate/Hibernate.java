/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author pjarana
 */
public class Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SessionFactory sesion=NewHibernateUtil.getSessionFactory();
       Session session=sesion.openSession();
       Query q= session.createQuery("from Pokemons");
       Iterator<Pokemons>lista=q.iterate();
       Pokemons p;
       while(lista.hasNext())
       {
           p=lista.next();
           System.out.print(p.getNombrePokemon()+" "+p.getHabilidad1());
       }
       session.close();
    }
    
}
