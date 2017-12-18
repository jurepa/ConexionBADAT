/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxActualizaciones;

/**
 *
 * @author pjarana
 */
public class Actualizacion{ 
        
    public Avion avion;
    public Incidencia incidencia;
    
    public Actualizacion()
    {
        //No instancio this.avion ya que puede ser null dependiendo los datos de la incidencia
        this.incidencia=new Incidencia();
    }
    public Actualizacion(Avion a, Incidencia i)
    {
        this.avion=a;
        this.incidencia=i;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Incidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Incidencia incidencia) {
        this.incidencia = incidencia;
    }
    
}
