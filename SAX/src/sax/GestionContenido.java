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
    private String contenido;
    @Override
    public void characters(char[] chars, int inicio, int longitud) 
    {
        String cad = new String(chars, inicio, longitud);
        cad = cad.replaceAll("[\t\n]","");
        this.contenido=cad;
//        if(this.etiquetaActual!=null)
//        {
//            switch(this.etiquetaActual)
//            {
//                case "title":
//                        libro.setTitulo(cad);
//                    break;
//                case "author":
//                        libro.addAutor(cad);
//                    break;
//                case "year":
//                        libro.setYear(Integer.parseInt(cad));
//                    break;
//                case "price":
//                        libro.setPrecio(Double.parseDouble(cad));
//                    break;
//            }
//        }
    }

    @Override
    public void endElement(String uri, String nombre, String nombreC) { 
        switch(nombre)
        {
                        
            case "title":                               
                libro.setTitulo(this.contenido);                           
                break;                     
            case "author":                            
                libro.addAutor(this.contenido);                          
                break;                        
            case "year":                       
                libro.setYear(Integer.parseInt(this.contenido));               
                break;
            case "price":
                libro.setPrecio(Double.parseDouble(this.contenido));
                break;
        }
        if(nombre.equals("book"))
        {
            libros.add(this.libro);
            System.out.println(this.libro.toString());
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
      }
    }

    @Override
    public void endDocument() {
        System.out.println("Fin");
        System.out.println(libros.toString());
    }

    @Override
    public void startDocument() {
        System.out.println("Comienza");
        libros=new ArrayList<Libro>();
    }
    
}
