/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernandocriaturitas;

import java.util.*;
import javax.persistence.TypedQuery;
import org.hibernate.*;

/**
 *
 * @author pjarana
 */
public class ManejadorCriaturitas {
    public void crearCriaturita (String nombre, Short id){
        Transaction tran;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        tran = ses.beginTransaction();
        Criaturitas nene = new Criaturitas();
        nene.setNombre(nombre);
        nene.setId(id);
		// Al ejecutar el m�todo save el objeto se convierte en persistente
        ses.save(nene);
        tran.commit();
        ses.close();
    }
    public Collection<Regalos> getRegalosCriaturita(Short id)
    {
        
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        Query consulta = ses.createQuery("from Regalos where goesTo=:id");
        consulta.setShort("id", id);
        List<Regalos> regalos=consulta.list();
        ses.close();
        return regalos;
    }
    public void cambiarNombre (String nombre, Short id){
        Criaturitas nene;
        Transaction tran;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        tran = ses.beginTransaction();
        nene = new Criaturitas (id);
        nene.setNombre (nombre);
        ses.update (nene);
        tran.commit();
        ses.close();
    }
    public void borrar (Short id){
        Criaturitas nene;
        Transaction tran;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        tran = ses.beginTransaction();
        nene = new Criaturitas (id);
        ses.delete (nene);
        tran.commit();
        ses.close();
    }
    public Criaturitas getCriaturitaPorId (Short id){
        Criaturitas nene;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        nene = (Criaturitas)ses.get(Criaturitas.class, id);
        ses.close();
        return nene;
    }
    public List<Criaturitas> getCriaturitas(){
        Query  consulta;
        List<Criaturitas> todasCria;
        // No necesitamos datos de la conexion porque ya est�n definidos en el hibernate.cfg.xml
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        String ordenConsulta ="from Criaturitas";
        consulta = ses.createQuery(ordenConsulta);
        todasCria=consulta.list();
        ses.close();
        return todasCria;

    }
    public void listaCriaturitas (List<Criaturitas> lista){
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        for (Criaturitas actual:lista){
            // El objeto es detached y con esto pasa a persistent
            ses.update(actual);
            System.out.println(cadenaCriaturita(actual));
        }
        ses.close();
    }
    public String cadenaCriaturita (Criaturitas c){
        String cad;
        cad = "ID: "+c.getId() + "  Nombre: " + c.getNombre();
        return cad;
    }
}