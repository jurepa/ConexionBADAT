/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernandocriaturitas;

/**
 *
 * @author pjarana
 */
public class HibernandoCriaturitas {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                final Short id = 3;
        final String nombre = "Violeta";
        ManejadorCriaturitas mc = new ManejadorCriaturitas();
//        mc.borrar(otro);
        //mc.crearCriaturita("Pepe",id);
        //mc.borrar(id);
        //mc.listaCriaturitas(mc.getCriaturitas());
        //System.out.println(mc.cadenaCriaturita(mc.getCriaturitaPorId(id)));
        //mc.cambiarNombre(nombre, id);
        //System.out.println("\n---------------------------\n"+mc.cadenaCriaturita(mc.recuperar(id)));
        System.out.println(mc.getRegalosCriaturita(id).toString());
    }
    
}
