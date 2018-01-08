import java.sql.SQLException;

public class GestoraActualizacion {

    /*
   Proposito: Recorre el ResultSet de EX_Actualizaciones y dependidendo del estado de las 
   		   columnas NombreAvion y Fabricante realizaremos inserciones en la tabla AS_Incidencias,
   		   AS_Aviones y/o daremos de baja a un avion/es y los futuros vuelos asociados si ha tenido
   		   un Accidente Definitivo
   Precondiciones: No hay
   Entradas: No hay
   Salidas: No hay
   Postcondiciones: Se ha actualizado la base de datos
   */
   public void actualizarDB(GestoraConsultas gestoraConsultas, Actualizacion actualizacion){
	   //ResultSet resultSet=gestoraConsultas.getResulSetActualizaciones();
   
         
       try {            	
    	   gestoraConsultas.getGestoraConexion().getConnect().setAutoCommit(false);
    	   
           	
           	
            //Si los datos del avion estan a null excepto la matricula es que el avion ya esta registrado
           	if(actualizacion.getAvion().getNombre()!=null && !actualizacion.getAvion().getNombreFabricante().equals("")) {
       			//Insertamos nuevo avion
           		gestoraConsultas.insertInToAviones(actualizacion.getAvion());               	
           	}                	
           	//Insertamos la incidencia
           	gestoraConsultas.insertInToIncidencias(actualizacion.getIncidencia());      
       		if(actualizacion.getAvion().getActivo()=="N") {
           		//Y efectuar�amos la baja con el procedimiento del ej 1
       			gestoraConsultas.executeBajaAvion(actualizacion.getAvion().getMatricula());
       		}
           
          //Eliminamos los  datos de la tabla EX_Actualizaciones
           //gestoraConsultas.deleteActualizaciones();
          
       } catch (SQLException e) {        	
       	System.out.println(e.getMessage()+"ES AQUI actulizarDB");
       }	   
   }
 
	
	
}
