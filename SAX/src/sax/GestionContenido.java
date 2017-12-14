/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author pjarana
 */
public class GestionContenido extends DefaultHandler {

    private String etiquetaActual;
    private ArrayList<Libro> libros;
    private Libro libro;
    @Override
    public void characters(char[] chars, int inicio, int longitud) 
    {
        String cad = new String(chars, inicio, longitud);
        cad = cad.replaceAll("[\t\n]",""); 
        switch(this.etiquetaActual)
        {
            case "Me gustan las Alemanas":
                    libro.setLenguaje("Aleman for Ever");
                break;
        }
    }

    @Override
    public void endElement(String uri, String nombre, String nombreC) {
        if(nombre.equals("book"))
        {
            libros.add(this.libro);
        }
    }

    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes atrbts) 
    {

      switch(nombre)
      {
          case "book":
              this.libro=new Libro();
              this.libro.setCategoria(atrbts.getValue(0));
              break;
          case "title":
              this.libro.setLenguaje(atrbts.getValue(0));
              this.etiquetaActual=nombre;
              break;
          case "author":
          case "year":
          case "price":
              this.etiquetaActual=nombre;
              break;
              
      }
    }

    @Override
    public void endDocument() {
        System.out.println("Empieza a leer el documento");
    }

    @Override
    public void startDocument() {
        System.out.println("Fin del documento");
    }
    
}
