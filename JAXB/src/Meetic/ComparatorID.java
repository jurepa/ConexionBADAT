/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meetic;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 *
 * @author pjarana
 */
public class ComparatorID implements Comparator {

    public int compare(Corazoncitos.Persona p1, Corazoncitos.Persona p2) 
    {
        int compare=0;
        if(p1.id>p2.id)
        {
            compare=1;
        }
        else if(p1.id<p2.id)
        {
            compare=-1;
        }
        return compare;
    }

    @Override
    public int compare(Object t, Object t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparator thenComparing(Comparator cmprtr) {
        return Comparator.super.thenComparing(cmprtr); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparator thenComparing(Function fnctn, Comparator cmprtr) {
        return Comparator.super.thenComparing(fnctn, cmprtr); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparator thenComparing(Function fnctn) {
        return Comparator.super.thenComparing(fnctn); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparator thenComparingInt(ToIntFunction tif) {
        return Comparator.super.thenComparingInt(tif); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparator thenComparingLong(ToLongFunction tlf) {
        return Comparator.super.thenComparingLong(tlf); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparator thenComparingDouble(ToDoubleFunction tdf) {
        return Comparator.super.thenComparingDouble(tdf); //To change body of generated methods, choose Tools | Templates.
    }
    
}
