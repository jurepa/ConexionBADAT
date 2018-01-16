/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meetic;

import java.util.Comparator;


/**
 *
 * @author pjarana
 */
public class ComparatorID implements Comparator<Corazoncitos.Persona> {


    @Override
    public int compare(Corazoncitos.Persona persona1, Corazoncitos.Persona persona2) {
        int compare=0;
        if(persona1.id>persona2.id)
        {
            compare=1;
        }
        else if(persona1.id<persona2.id)
        {
            compare=-1;
        }
        return compare;
    }  
}
