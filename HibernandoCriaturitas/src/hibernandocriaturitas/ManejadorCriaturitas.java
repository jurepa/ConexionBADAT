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
		// Al ejecutar el método save el objeto se convierte en persistente
        ses.save(nene);
        tran.commit();
        ses.close();
    }
    
    public void crearCriaturitaConRegalos(Criaturitas criaturita, Regalos regalo1, Regalos regalo2)
    {
        Transaction tran;
        regalo1.setGoesTo(criaturita);
        regalo2.setGoesTo(criaturita);
        criaturita.setRegalosCollection(new ArrayList<Regalos>());
        criaturita.getRegalosCollection().add(regalo1);
        criaturita.getRegalosCollection().add(regalo2);
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        //tran = ses.beginTransaction();
        ses.save(criaturita);
        ses.save(regalo1);
        ses.save(regalo2);
        //tran.commit(); Me da problemas la transaccion, se queda colgado el hibernate
        ses.close();
    }
    
    public void crearRegaloYAsignar(Regalos regalo, Short idCriaturita)
    {
        Transaction tran;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        Criaturitas criaturita=getCriaturitaPorId(idCriaturita);
        tran=ses.beginTransaction();
        regalo.setGoesTo(criaturita);
        if(criaturita.getRegalosCollection()==null) //Si no tiene ningun regalo asignado
        {
            criaturita.setRegalosCollection(new ArrayList<Regalos>());
            criaturita.getRegalosCollection().add(regalo);
        }
        else
        {
            Hibernate.initialize(criaturita.getRegalosCollection().add(regalo));
        }
        ses.save(regalo);
        ses.update(criaturita);
        tran.commit();
        ses.close();
    }
    
    public void deleteCriaturitaConRegalos(Short idCriaturita)
    {
        Criaturitas nene;
        Transaction tran;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        tran = ses.beginTransaction();
        List<Regalos>regalitos=(List<Regalos>) getRegalosCriaturita(idCriaturita);
        for(int i=0;i<regalitos.size();i++)
        {
            Regalos regalo=regalitos.get(i);
            ses.delete(regalo);    
        }
        nene = new Criaturitas (idCriaturita);
        ses.delete (nene);
        tran.commit();
        ses.close();
    }
    
    public void cambiarPropietarioRegalo(Short idRegalo, Short idCriaturita)
    {
        Transaction t;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        t=ses.beginTransaction();
        Criaturitas criaturitaDestino= getCriaturitaPorId(idCriaturita);
        Regalos regalo=new ManejadorRegalos().getRegaloPorId(idRegalo);
        regalo.setGoesTo(criaturitaDestino);
        ses.update(regalo);
        t.commit();
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
        // No necesitamos datos de la conexion porque ya están definidos en el hibernate.cfg.xml
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
