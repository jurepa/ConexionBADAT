/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernandocriaturitas;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pjarana
 */
public class ManejadorRegalos {
    
    public Regalos getRegaloPorId(Short idRegalo)
    {
        Regalos regalo;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        regalo = (Regalos)ses.get(Regalos.class, idRegalo);
        ses.close();
        return regalo;
    }
    
    public void deleteRegalo(Short idRegalo)
    {
        Transaction tran;
        Session ses = NewHibernateUtil.getSessionFactory().openSession();
        tran=ses.beginTransaction();
        Regalos regalo=getRegaloPorId(idRegalo);
        ses.delete(regalo);
        tran.commit();
        ses.close();
    }
}
