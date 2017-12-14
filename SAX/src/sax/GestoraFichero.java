package sax;


/**
 *
 * @author Leo
 */

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class GestoraFichero {
    XMLReader procesadorXML;
    GestionContenido gestor;
    InputSource archivoXML;
    public GestoraFichero (String nombreArchivo){
        try {
            procesadorXML = XMLReaderFactory.createXMLReader();
        } catch (SAXException ex) {
            Logger.getLogger(GestoraFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        gestor = new GestionContenido();
        procesadorXML.setContentHandler(gestor);
        archivoXML = new InputSource(nombreArchivo);
    }
    void andale(){
        try {
            procesadorXML.parse(archivoXML);
        } catch (IOException ex) {
            Logger.getLogger(GestoraFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(GestoraFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
// Fin PruebaSAX1
