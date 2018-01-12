/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meetic;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author pjarana
 */
public class PersonaEscribible extends Corazoncitos.Persona
{
    public PersonaEscribible (Corazoncitos.Persona uno){
        super();
        this.fechaNacimiento=uno.fechaNacimiento;
        this.id=uno.id;
        this.ingresos=uno.ingresos;
        this.nombre=uno.nombre;
        this.preferencias=uno.preferencias;
        this.sexo=uno.sexo;
        this.sexoBuscado=uno.sexoBuscado;     
    }
    
    public String getTodo (){
        String cadAtomo;
        cadAtomo = "Id: "+this.id;
        cadAtomo +="\nNombre: "+this.nombre;
        cadAtomo +="\nFecha Nacimiento: "+this.fechaNacimiento;
        cadAtomo +="\nIngresos: "+this.ingresos;
        cadAtomo +="\nPreferencias: "+this.preferencias;
        cadAtomo +="\nSexo: "+this.sexo;
        cadAtomo +="\nSexoBuscado: "+this.sexoBuscado;
        return cadAtomo;
    }

    public int compareTo(Corazoncitos.Persona p)
    {
        int compare=0;
        if(this.id>p.id)
        {
            compare=1;
        }
        else if(this.id<p.id)
        {
            compare=-1;
        }
        return compare;
    }
}
