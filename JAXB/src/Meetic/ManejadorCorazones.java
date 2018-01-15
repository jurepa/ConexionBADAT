
package Meetic;


import jaxb.*;
import java.io.*;
import javax.xml.bind.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Meetic.Corazoncitos;
import java.util.ArrayList;
/**
 *
 * @author Leo
 */
public class ManejadorCorazones {
    Corazoncitos listaCorazoncitos;
    Corazoncitos listaMasCorazoncitos;
    ArrayList<Corazoncitos.Persona> listaCorazonesFusionados;
    ComparatorID comparator;
    public void abrirListaCorazoncitosJAXB (File corazoncitosXML, File masCorazoncitosXML ){
        JAXBContext contexto;
        try {
            comparator=new ComparatorID();
            listaCorazonesFusionados=new ArrayList<Corazoncitos.Persona>();
            contexto = JAXBContext.newInstance(Corazoncitos.class);
            Unmarshaller u = contexto.createUnmarshaller();
            listaCorazoncitos = (Corazoncitos) u.unmarshal(corazoncitosXML);
            listaMasCorazoncitos=(Corazoncitos) u.unmarshal(masCorazoncitosXML);
            listaCorazonesFusionados.addAll(listaCorazoncitos.persona);
            listaCorazonesFusionados.addAll(listaMasCorazoncitos.persona);
            listaCorazonesFusionados.sort(comparator);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public void recorreListaCorazoncitos(){
        PersonaEscribible p;
        List<Corazoncitos.Persona> miListaCorazoncitos = listaCorazoncitos.getPersona();
        for(Corazoncitos.Persona c:miListaCorazoncitos){
            p = new PersonaEscribible(c);
            System.out.println("\nSiguiente elemento\n----------------------------------------------");
            System.out.println(p.getTodo());
        }
    }
    public void anadirAtomo(Corazoncitos.Persona nuevo){
        listaCorazoncitos.getPersona().add(nuevo);
    }
    public void guardarListaAtomos(File archivoXML){
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Atomos.class);
            Marshaller marshalero = contexto.createMarshaller();
            marshalero.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter escribiente = new StringWriter();
            marshalero.marshal(listaCorazoncitos, archivoXML);
            // ahora lo marshaleamos a un stream para visualizarlo
            marshalero.marshal(listaCorazoncitos, escribiente);
            System.out.println("-----------------");
            System.out.println("Object2XML:");
            System.out.println(escribiente.toString());
            System.out.println("-----------------");
        } catch (JAXBException ex) {
            Logger.getLogger(ManejadorCorazones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
