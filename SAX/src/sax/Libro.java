/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import java.util.ArrayList;

/**
 *
 * @author pjarana
 */
public class Libro 
{
    private String categoria;
    private String titulo;
    private String lenguaje;
    private ArrayList<String> autores;
    private int year;
    private double precio;
    
    public Libro()
    {
        this.categoria="";
        this.titulo="";
        this.lenguaje="";
        this.autores=new ArrayList<String>();
        this.year=0;
        this.precio=0.0;
    }

    public Libro(String categoria, String titulo, String lenguaje, ArrayList<String> autores, int year, double precio) {
        this.categoria = categoria;
        this.titulo = titulo;
        this.lenguaje = lenguaje;
        this.autores = autores;
        this.year = year;
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
