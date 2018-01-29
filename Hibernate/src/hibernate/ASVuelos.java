package hibernate;
// Generated 23-ene-2018 8:49:56 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * AsVuelos generated by hbm2java
 */
public class ASVuelos  implements java.io.Serializable {


     private int codigo;
     private ASAeropuertos asAeropuertosByAeropuertoSalida;
     private ASAeropuertos asAeropuertosByAeropuertoLlegada;
     private ASAviones asAviones;
     private Date salida;
     private Date llegada;
     private BigDecimal precioPasaje;

    public ASVuelos() {
    }

	
    public ASVuelos(int codigo, ASAeropuertos asAeropuertosByAeropuertoSalida, ASAeropuertos asAeropuertosByAeropuertoLlegada, ASAviones asAviones, Date salida, Date llegada) {
        this.codigo = codigo;
        this.asAeropuertosByAeropuertoSalida = asAeropuertosByAeropuertoSalida;
        this.asAeropuertosByAeropuertoLlegada = asAeropuertosByAeropuertoLlegada;
        this.asAviones = asAviones;
        this.salida = salida;
        this.llegada = llegada;
    }
    public ASVuelos(int codigo, ASAeropuertos asAeropuertosByAeropuertoSalida, ASAeropuertos asAeropuertosByAeropuertoLlegada, ASAviones asAviones, Date salida, Date llegada, BigDecimal precioPasaje) {
       this.codigo = codigo;
       this.asAeropuertosByAeropuertoSalida = asAeropuertosByAeropuertoSalida;
       this.asAeropuertosByAeropuertoLlegada = asAeropuertosByAeropuertoLlegada;
       this.asAviones = asAviones;
       this.salida = salida;
       this.llegada = llegada;
       this.precioPasaje = precioPasaje;
    }
   
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public ASAeropuertos getAsAeropuertosByAeropuertoSalida() {
        return this.asAeropuertosByAeropuertoSalida;
    }
    
    public void setAsAeropuertosByAeropuertoSalida(ASAeropuertos asAeropuertosByAeropuertoSalida) {
        this.asAeropuertosByAeropuertoSalida = asAeropuertosByAeropuertoSalida;
    }
    public ASAeropuertos getAsAeropuertosByAeropuertoLlegada() {
        return this.asAeropuertosByAeropuertoLlegada;
    }
    
    public void setAsAeropuertosByAeropuertoLlegada(ASAeropuertos asAeropuertosByAeropuertoLlegada) {
        this.asAeropuertosByAeropuertoLlegada = asAeropuertosByAeropuertoLlegada;
    }
    public ASAviones getAsAviones() {
        return this.asAviones;
    }
    
    public void setAsAviones(ASAviones asAviones) {
        this.asAviones = asAviones;
    }
    public Date getSalida() {
        return this.salida;
    }
    
    public void setSalida(Date salida) {
        this.salida = salida;
    }
    public Date getLlegada() {
        return this.llegada;
    }
    
    public void setLlegada(Date llegada) {
        this.llegada = llegada;
    }
    public BigDecimal getPrecioPasaje() {
        return this.precioPasaje;
    }
    
    public void setPrecioPasaje(BigDecimal precioPasaje) {
        this.precioPasaje = precioPasaje;
    }




}


