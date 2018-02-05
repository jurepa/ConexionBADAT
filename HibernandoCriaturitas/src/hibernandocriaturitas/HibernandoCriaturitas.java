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
        final Short idCriaturita = 2, idRegalo=13, idCriaturitaNueva=40, idRegalo1=30, idRegalo2=31;
        final String nombre = "Violeta";
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
        ManejadorCriaturitas mc = new ManejadorCriaturitas();
        mc.cambiarPropietarioRegalo(idRegalo,idCriaturita);
        mc.crearCriaturitaConRegalos(criaturita, regalo1, regalo2);
        mc.deleteCriaturitaConRegalos(idCriaturitaNueva);
        //mc.borrar(otro);
        //mc.crearCriaturita("Pepe",id);
        //mc.borrar(id);
        //mc.listaCriaturitas(mc.getCriaturitas());
        //System.out.println(mc.cadenaCriaturita(mc.getCriaturitaPorId(id)));
        //mc.cambiarNombre(nombre, id);
        //System.out.println("\n---------------------------\n"+mc.cadenaCriaturita(mc.recuperar(id)));
        System.out.println(mc.getRegalosCriaturita(idCriaturita).toString());
    }
    
}
