/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxActualizaciones;

import java.sql.Timestamp;

/**
 *
 * @author pjarana
 * 
 */
public class Avion {
    private String matriculaAvion;
    private String nombre;
    private String fabricante;
    private String modelo;
    private java.sql.Timestamp fechaEntrada;
    private java.sql.Timestamp fechaFabricacion;
    private int filas;
    private int asientosXFila;
    private int autonomia;

    public Avion() {
        this.nombre="";
        this.fabricante="";
        this.modelo="";
        this.fechaEntrada=new java.sql.Timestamp(2);
        this.fechaFabricacion=new java.sql.Timestamp(1);
        this.filas=0;
        this.asientosXFila=0;
        this.autonomia=0;
    }

    public Avion(String matriculaAvion, String nombre, String fabricante, String modelo, Timestamp fechaEntrada, Timestamp fechaFabricacion, int filas, int asientosXFila, int autonomia) {
        this.matriculaAvion = matriculaAvion;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.fechaEntrada = fechaEntrada;
        this.fechaFabricacion = fechaFabricacion;
        this.filas = filas;
        this.asientosXFila = asientosXFila;
        this.autonomia = autonomia;
    }

    public String getMatriculaAvion() {
        return matriculaAvion;
    }

    public void setMatriculaAvion(String matriculaAvion) {
        this.matriculaAvion = matriculaAvion;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Timestamp getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Timestamp fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getAsientosXFila() {
        return asientosXFila;
    }

    public void setAsientosXFila(int asientosXFila) {
        this.asientosXFila = asientosXFila;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
    
    
}
