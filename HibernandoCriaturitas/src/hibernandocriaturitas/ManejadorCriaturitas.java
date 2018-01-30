/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernandocriaturitas;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
    public Criaturitas recuperar (Short id){
        Criaturitas nene;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        nene = (Criaturitas)ses.get(Criaturitas.class, id);
        ses.close();
        return nene;
    }
    public List<Criaturitas> getCriaturitas(){
        TypedQuery  consulta;
        List<Criaturitas> todasCria;
        // No necesitamos datos de la conexion porque ya están definidos en el hibernate.cfg.xml
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        String ordenConsulta ="from Criaturitas";
        consulta = ses.createQuery(ordenConsulta);
        todasCria=consulta.getResultList();
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
