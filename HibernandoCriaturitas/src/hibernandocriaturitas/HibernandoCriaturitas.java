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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                final Short id = 6, otro = 15;
        final String nombre = "Violeta";
        ManejadorCriaturitas mc = new ManejadorCriaturitas();
//        mc.borrar(otro);
//        mc.crearCriaturita(nombre,id);
        mc.listaCriaturitas(mc.getCriaturitas());
//        mc.cambiarNombre(nombre, id);
        System.out.println("\n---------------------------\n"+mc.cadenaCriaturita(mc.recuperar(id)));
    }
    
}
