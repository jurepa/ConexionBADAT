/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernandocriaturitas;

import org.hibernate.Session;

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
}
