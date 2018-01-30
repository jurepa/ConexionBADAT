/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pjarana
 */
@Entity
@Table(name = "Pokemons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pokemons.findAll", query = "SELECT p FROM Pokemons p")
    , @NamedQuery(name = "Pokemons.findByIdPokemon", query = "SELECT p FROM Pokemons p WHERE p.idPokemon = :idPokemon")
    , @NamedQuery(name = "Pokemons.findByNombrePokemon", query = "SELECT p FROM Pokemons p WHERE p.nombrePokemon = :nombrePokemon")
    , @NamedQuery(name = "Pokemons.findByNumEvoluciones", query = "SELECT p FROM Pokemons p WHERE p.numEvoluciones = :numEvoluciones")
    , @NamedQuery(name = "Pokemons.findByGeneracion", query = "SELECT p FROM Pokemons p WHERE p.generacion = :generacion")
    , @NamedQuery(name = "Pokemons.findByHabilidad1", query = "SELECT p FROM Pokemons p WHERE p.habilidad1 = :habilidad1")
    , @NamedQuery(name = "Pokemons.findByHabilidad2", query = "SELECT p FROM Pokemons p WHERE p.habilidad2 = :habilidad2")
    , @NamedQuery(name = "Pokemons.findByHabilidadOculta", query = "SELECT p FROM Pokemons p WHERE p.habilidadOculta = :habilidadOculta")
    , @NamedQuery(name = "Pokemons.findByPeso", query = "SELECT p FROM Pokemons p WHERE p.peso = :peso")
    , @NamedQuery(name = "Pokemons.findByAltura", query = "SELECT p FROM Pokemons p WHERE p.altura = :altura")
    , @NamedQuery(name = "Pokemons.findByH\u00e1bitat", query = "SELECT p FROM Pokemons p WHERE p.h\u00e1bitat = :h\u00e1bitat")})
public class Pokemons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPokemon")
    private Integer idPokemon;
    @Basic(optional = false)
    @Column(name = "nombrePokemon")
    private String nombrePokemon;
    @Basic(optional = false)
    @Column(name = "numEvoluciones")
    private short numEvoluciones;
    @Basic(optional = false)
    @Column(name = "Generacion")
    private short generacion;
    @Basic(optional = false)
    @Column(name = "Habilidad1")
    private String habilidad1;
    @Column(name = "Habilidad2")
    private String habilidad2;
    @Column(name = "HabilidadOculta")
    private String habilidadOculta;
    @Basic(optional = false)
    @Column(name = "Peso")
    private double peso;
    @Basic(optional = false)
    @Column(name = "Altura")
    private double altura;
    @Basic(optional = false)
    @Column(name = "H\u00e1bitat")
    private String hábitat;

    public Pokemons() {
    }

    public Pokemons(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public Pokemons(Integer idPokemon, String nombrePokemon, short numEvoluciones, short generacion, String habilidad1, double peso, double altura, String hábitat) {
        this.idPokemon = idPokemon;
        this.nombrePokemon = nombrePokemon;
        this.numEvoluciones = numEvoluciones;
        this.generacion = generacion;
        this.habilidad1 = habilidad1;
        this.peso = peso;
        this.altura = altura;
        this.hábitat = hábitat;
    }

    public Integer getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(Integer idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public short getNumEvoluciones() {
        return numEvoluciones;
    }

    public void setNumEvoluciones(short numEvoluciones) {
        this.numEvoluciones = numEvoluciones;
    }

    public short getGeneracion() {
        return generacion;
    }

    public void setGeneracion(short generacion) {
        this.generacion = generacion;
    }

    public String getHabilidad1() {
        return habilidad1;
    }

    public void setHabilidad1(String habilidad1) {
        this.habilidad1 = habilidad1;
    }

    public String getHabilidad2() {
        return habilidad2;
    }

    public void setHabilidad2(String habilidad2) {
        this.habilidad2 = habilidad2;
    }

    public String getHabilidadOculta() {
        return habilidadOculta;
    }

    public void setHabilidadOculta(String habilidadOculta) {
        this.habilidadOculta = habilidadOculta;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getHábitat() {
        return hábitat;
    }

    public void setHábitat(String hábitat) {
        this.hábitat = hábitat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPokemon != null ? idPokemon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pokemons)) {
            return false;
        }
        Pokemons other = (Pokemons) object;
        if ((this.idPokemon == null && other.idPokemon != null) || (this.idPokemon != null && !this.idPokemon.equals(other.idPokemon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.Pokemons[ idPokemon=" + idPokemon + " ]";
    }
    
}
