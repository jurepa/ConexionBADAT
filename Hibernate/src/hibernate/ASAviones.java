package hibernate;
// Generated 23-ene-2018 8:49:56 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AsAviones generated by hbm2java
 */
public class AsAviones  implements java.io.Serializable {


     private String matricula;
     private AsFabricantes asFabricantes;
     private String nombre;
     private String modelo;
     private Date fechaFabricacion;
     private Date fechaEntrada;
     private short filas;
     private byte asientosXFila;
     private Integer autonomia;
     private char activo;
     private Set asVueloses = new HashSet(0);
     private Set asIncidenciases = new HashSet(0);

    public AsAviones() {
    }

	
    public AsAviones(String matricula, AsFabricantes asFabricantes, String nombre, String modelo, short filas, byte asientosXFila, char activo) {
        this.matricula = matricula;
        this.asFabricantes = asFabricantes;
        this.nombre = nombre;
        this.modelo = modelo;
        this.filas = filas;
        this.asientosXFila = asientosXFila;
        this.activo = activo;
    }
    public AsAviones(String matricula, AsFabricantes asFabricantes, String nombre, String modelo, Date fechaFabricacion, Date fechaEntrada, short filas, byte asientosXFila, Integer autonomia, char activo, Set asVueloses, Set asIncidenciases) {
       this.matricula = matricula;
       this.asFabricantes = asFabricantes;
       this.nombre = nombre;
       this.modelo = modelo;
       this.fechaFabricacion = fechaFabricacion;
       this.fechaEntrada = fechaEntrada;
       this.filas = filas;
       this.asientosXFila = asientosXFila;
       this.autonomia = autonomia;
       this.activo = activo;
       this.asVueloses = asVueloses;
       this.asIncidenciases = asIncidenciases;
    }
   
    public String getMatricula() {
        return this.matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public AsFabricantes getAsFabricantes() {
        return this.asFabricantes;
    }
    
    public void setAsFabricantes(AsFabricantes asFabricantes) {
        this.asFabricantes = asFabricantes;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Date getFechaFabricacion() {
        return this.fechaFabricacion;
    }
    
    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }
    public Date getFechaEntrada() {
        return this.fechaEntrada;
    }
    
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    public short getFilas() {
        return this.filas;
    }
    
    public void setFilas(short filas) {
        this.filas = filas;
    }
    public byte getAsientosXFila() {
        return this.asientosXFila;
    }
    
    public void setAsientosXFila(byte asientosXFila) {
        this.asientosXFila = asientosXFila;
    }
    public Integer getAutonomia() {
        return this.autonomia;
    }
    
    public void setAutonomia(Integer autonomia) {
        this.autonomia = autonomia;
    }
    public char getActivo() {
        return this.activo;
    }
    
    public void setActivo(char activo) {
        this.activo = activo;
    }
    public Set getAsVueloses() {
        return this.asVueloses;
    }
    
    public void setAsVueloses(Set asVueloses) {
        this.asVueloses = asVueloses;
    }
    public Set getAsIncidenciases() {
        return this.asIncidenciases;
    }
    
    public void setAsIncidenciases(Set asIncidenciases) {
        this.asIncidenciases = asIncidenciases;
    }




}

