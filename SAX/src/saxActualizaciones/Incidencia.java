/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxActualizaciones;

import java.math.BigDecimal;

/**
 *
 * @author pjarana
 * insertIncidencia(cx, rsActualizaciones.getString("MatriculaAvion"),
                        rsActualizaciones.getBigDecimal("Latitud"),
                        rsActualizaciones.getBigDecimal("Longitud"), 
                        rsActualizaciones.getString("Descripcion"),
                        rsActualizaciones.getString("Tipo"));
 */
public class Incidencia {
    
    private String matriculaAvion;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String descripcion;
    private String tipo;

    public Incidencia() {
        this.matriculaAvion="";
        this.latitud=null;
        this.longitud=null;
        this.descripcion="";
        this.tipo="";
    }

    public Incidencia(String matriculaAvion, BigDecimal latitud, BigDecimal longitud, String descripcion, String tipo) {
        this.matriculaAvion = matriculaAvion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getMatriculaAvion() {
        return matriculaAvion;
    }

    public void setMatriculaAvion(String matriculaAvion) {
        this.matriculaAvion = matriculaAvion;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
