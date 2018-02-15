/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernandocriaturitas;

import java.math.BigDecimal;

/**
 *
 * @author pjarana
 */
public class HibernandoCriaturitas {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Short idCriaturita = 3, idRegalo=4, idCriaturitaNueva=40, idRegalo1=30, idRegalo2=31;
        final String nombre = "Violeta";
        ManejadorCriaturitas mc = new ManejadorCriaturitas();
        ManejadorRegalos mr=new ManejadorRegalos();
        
        //Sets regalitos y criaturitas
        Criaturitas criaturita=new Criaturitas(idCriaturitaNueva);
        criaturita.setId(idCriaturitaNueva);
        criaturita.setNombre("Jarana");
        Regalos regalo1=new Regalos(idRegalo1);
        Regalos regalo2=new Regalos(idRegalo2);
        regalo1.setAlto(idRegalo);
        regalo1.setDenominacion("Jarana Present1");
        regalo1.setAncho(idRegalo);
        regalo1.setEdadMinima(idRegalo);
        regalo1.setLargo(idRegalo);
        regalo1.setTipo('M');
        regalo1.setPrecio(new BigDecimal(20));
        regalo2.setAlto(idRegalo);
        regalo2.setDenominacion("Jarana Present2");
        regalo2.setAncho(idRegalo);
        regalo2.setEdadMinima(idRegalo);
        regalo2.setLargo(idRegalo);
        regalo2.setTipo('M');
        regalo2.setPrecio(new BigDecimal(20));
        //Fin sets regalitos y criaturitas

        //Pruebas
        mc.cambiarPropietarioRegalo(idRegalo,idCriaturita);
        System.out.print(mc.getCriaturitaPorId(idCriaturita).getRegalosCollection().toString());
        /*mc.crearCriaturitaConRegalos(criaturita, regalo1, regalo2);
        mc.deleteCriaturitaConRegalos(idCriaturitaNueva);
        mc.crearRegaloYAsignar(regalo2, idCriaturita);    
        System.out.println(mc.getRegalosCriaturita(idCriaturita).toString());
        mr.deleteRegalo(idRegalo2);*/
        //System.out.println("Borrado");
        //Fin_Pruebas
        
    }
    
}
