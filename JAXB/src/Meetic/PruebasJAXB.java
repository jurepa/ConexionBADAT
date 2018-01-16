/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Meetic;

import jaxb.*;
import java.io.File;


/**
 *
 * @author Leo
 */
public class PruebasJAXB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManejadorCorazones ma = new ManejadorCorazones();
        File xml1 = new File("src\\Meetic\\corazonesSolitarios.xml");
        File xml2 = new File("src\\Meetic\\masCorazones.xml");
        File xmlDestino=new File("src\\Meetic\\corazonesFusionados.xml");
        // Cargamos el XML mediante unmarshaling
        ma.abrirListaCorazoncitosJAXB(xml1,xml2);
        // Comprobamos que se ha cargado
        ma.recorreListaCorazoncitos();
        // Ahora vamos a añadir otro átomo

        // Y generamso un nuevo XML mediante marshaling
        ma.guardarListaAtomos(xmlDestino);
    }
}
