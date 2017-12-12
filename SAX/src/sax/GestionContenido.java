/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author pjarana
 */
public class GestionContenido extends DefaultHandler {

    
    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        super.characters(chars, i, i1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endElement(String string, String string1, String string2) throws SAXException {
        super.endElement(string, string1, string2); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startElement(String uri, String nombre, String nombreC, Attributes atrbts) throws SAXException {
      
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
