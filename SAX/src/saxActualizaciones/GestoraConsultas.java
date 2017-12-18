package saxActualizaciones;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author icastillo
 * 
 * 
 */
public class GestoraConsultas {
	
    private GestoraConexion conexion;
    private GestoraSentencias gestoraSentencias;
    private ResultSet resultSetAct;
    
    public GestoraConsultas(){
        conexion=new GestoraConexion();
        gestoraSentencias=new GestoraSentencias();
        //gestoraSentencias.preparaSentencias();//si estos dos metodos los modulo quiz�s pueda abrir la conexi�n una �nica vez sin necesidad de hacerlo en GestoraSentencias
        //resultSetAct=gestoraSentencias.getResultSetActualizable();
    }
    
    public GestoraConexion getGestoraConexion(){
        return conexion;
    }
    
    public GestoraSentencias getGestoraSentencias(){
    	return gestoraSentencias;
    }
    
    
    /*
    Proposito: Prepara las sentencias de la GestoraSentencias
    Precondiciones: La conexion debe estar abierta
    Entradas: No hay
    Salidas: No hay
    Postcondiciones: Se han preparado las sentencias de la GestoraSentencias
    */
    public void preparaSentencias(){
    	gestoraSentencias.preparaSentencias(conexion);
    }
    
    /*
    Proposito: Carga la propiedad resultSetAct con un ResultSet Actualizable
    Precondiciones: No hay
    Entradas: No hay
    Salidas: No hay
    Postcondiciones: Se ha cargado en la propiedad resultSetAct el contenido de la tabla AS_Aviones
    */
    public void cargaResultSetActualizable(){
    	resultSetAct=gestoraSentencias.getResultSetActualizable();
    }
    
    /*
    Proposito: Carga en un ResultSet en contenido de la tabla EX_Actualizaciones
    Precondiciones: No hay
    Entradas: No hay
    Salidas: Un ResultSet con el resultado de la consulta a EX_Actualizaciones
    Postcondiciones: Se ha cargado en un ResultSet el contenido de la tabla EX_Actualizaciones
    */
    public ResultSet getResulSetActualizaciones(){     
        String consulta="SELECT MatriculaAvion, Latitud, Longitud, Descripcion, Tipo, AccidenteDefinitivo,"
        				+ "NombreAvion, Fabricante, Modelo, Fecha_Fabricacion, Fecha_Entrada, Filas, "
        				+ "Asientos_x_Fila, Autonomia FROM EX_Actualizaciones";	
        Statement sentencia;
        ResultSet resultSet=null;
        
        try {
            sentencia=conexion.getConnect().createStatement();
            resultSet=sentencia.executeQuery(consulta);                                          
        } catch (SQLException e) {
        	System.out.println(e.getMessage());        
        }      
        return resultSet;
    }
    
    //CAMBIO ESTE METODO A LA GestoraMain CON EL FIN DE EVITAR ACOPLAMIENTO
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
    /*public Integer[] actualizarDB(){
    	Integer[] tablaFilasAfectadas={0,0,0};
    	ResultSet resultSet=getResulSetActualizaciones();
        Incidencia incidencia=new Incidencia();
        Avion avion=new Avion();
               
        if(resultSet!=null){
            try {            	
            	conexion.getConnect().setAutoCommit(false);
                while(resultSet.next()){
            	
                	//Damos los datos al avion
                	avion.setNombre(resultSet.getString("NombreAvion"));
                	avion.setMatricula(resultSet.getString("MatriculaAvion"));                	
                	if(resultSet.getString("Fabricante")!=null){
                		avion.setIdFabricante(getIdFabricante(resultSet.getString("Fabricante")));
                	}
                	avion.setModelo(resultSet.getString("Modelo"));
                	avion.setFechaFabricacion(resultSet.getDate("Fecha_Fabricacion"));
                	avion.setFechaEntrada(resultSet.getDate("Fecha_Entrada"));                	
                	avion.setFilas(resultSet.getInt("Filas"));               	
                	avion.setAsientosXFila(resultSet.getInt("Asientos_x_Fila"));
                	avion.setAutonomia(resultSet.getInt("Autonomia"));
                	if(resultSet.getBoolean("AccidenteDefinitivo")) {
                		avion.setActivo("N");
                	}else {
                		avion.setActivo("S");
                	}
                	
                	//Damos los datos a la incidencia
                	incidencia.setMatriculaAvion(avion.getMatricula());
                	incidencia.setLatitud(resultSet.getBigDecimal("Latitud"));
                	incidencia.setLongitud(resultSet.getBigDecimal("Longitud"));
                	incidencia.setDescripcion(resultSet.getString("Descripcion"));
                	incidencia.setTipo(resultSet.getString("Tipo"));             	
                	
                    //Si los datos del avion estan a null excepto la matricula es que el avion ya esta registrado
                	if(avion.getNombre()!=null && avion.getIdFabricante()!=-1) {
            			//Insertamos nuevo avion
                		tablaFilasAfectadas[0]=tablaFilasAfectadas[0]+insertInToAviones(avion);               	
                	}                	
                	//Insertamos la incidencia
                	tablaFilasAfectadas[1]=tablaFilasAfectadas[1]+insertInToIncidencias(incidencia);      
            		if(avion.getActivo()=="N") {
                		//Y efectuar�amos la baja con el procedimiento del ej 1
            			tablaFilasAfectadas[2]=tablaFilasAfectadas[2]+executeBajaAvion(avion.getMatricula());
            		}
                }//fin mientras
                
               //Eliminamos los  datos de la tabla EX_Actualizaciones
               deleteActualizaciones();
               
            } catch (SQLException e) {        	
            	System.out.println(e.getMessage()+"ES AQUI actulizarDB");
            }
        }//fin si
        return tablaFilasAfectadas;
    }*/
    
    
    /*
    Proposito: Realiza una insercion en la tabla AS_Aviones mediante un resultSet actualizable
    Precondiciones: No hay
    Entradas: Un objeto Avion
    Salidas: Un entero con la cantidad de filas afectadas
    Postcondiciones: Se ha insertado en la Tabla AS_Aviones el nuevo Avion
    */
    public int insertInToAviones(Avion avion){
        int filasAfectadas=0;
        try{
        	//conexion.getConnect().setAutoCommit(false);
        	if(this.resultSetAct.next()){        				
        		
        		//Posicionamos el cursor en la fila de inserci�n
        		this.resultSetAct.moveToInsertRow();
        		
        		//Cambiamos los datos para esa fila
        		this.resultSetAct.updateString("Matricula", avion.getMatriculaAvion());
        		this.resultSetAct.updateString("Nombre", avion.getNombre());
        		this.resultSetAct.updateString("Modelo", avion.getModelo());
        		this.resultSetAct.updateTimestamp("Fecha_Fabricacion", avion.getFechaFabricacion());        		
        		this.resultSetAct.updateTimestamp("Fecha_Entrada", avion.getFechaEntrada());
        		this.resultSetAct.updateInt("Filas", avion.getFilas());
        		this.resultSetAct.updateInt("Asientos_x_Fila", avion.getAsientosXFila());
        		this.resultSetAct.updateInt("Autonomia", avion.getAutonomia());

        		//Y la insertamos
        		this.resultSetAct.insertRow();
        		filasAfectadas=1;
        		conexion.getConnect().commit();
        	}
        }catch(SQLException e){
        	System.out.println(e.getMessage());
            //Si algo falla hacemos rollback
            conexion.getConnect().rollback();
        }
        return filasAfectadas;
    }

    
    /*
    Proposito: Dado un nombre de fabricante busca el id del mismo en la base de datos y lo devuelve
    Precondiciones: No hay
    Entradas: String nombre del fabricante
    Salidas: Un short que es el id del fabricante
    Postcondiciones: El entero es el id del fabricante
    */
    public short getIdFabricante(String nombre) {
    	short id=0;
        ResultSet resultSet=null;      
        try {
        	gestoraSentencias.getPreparedStatementSelectIdFabricante().setString(1, nombre);
            resultSet=gestoraSentencias.getPreparedStatementSelectIdFabricante().executeQuery();    
            if(resultSet.next()) {
            	id=resultSet.getShort("ID_Fabricante");
            }
        } catch (SQLException e) {
        	System.out.println(e.getMessage());     
        }          	    	
    	return id;
    }   
       
    /*
    Proposito: Dada un matricula de avion marca a �ste como no activo en la base de datos
    Precondiciones: No hay
    Entradas: String matricula del avion
    Salidas: Un entero
    Postcondiciones: Se ha marcado el avion como no activo en la base de datos y se eliminan los futuros 
    			     vuelos asociados. 
    			     El entero que ser� 1 si la baja se realiz� correctamente y 0 sino
    */
    public int executeBajaAvion(String matricula) {
    	int bajaCorrecta=0;
        gestoraSentencias.getCallableStatementExecBajaAvion().setString(1, matricula); //Si algo falla hacemos rollback
        gestoraSentencias.getCallableStatementExecBajaAvion().executeUpdate();
        bajaCorrecta=1;
        conexion.getConnect().commit();//No estoy seguro de si al ejecutar el procedimiento almacenado deber�a hacer commit aqu�
    	return bajaCorrecta;
    }
        
    /*
    Proposito: Realiza una insercion en la table AS_Incidencias 
    Precondiciones: No hay
    Entradas: Un objeto Incidencia
    Salidas: Un entero con la cantidad de filas afectadas
    Postcondiciones: Se ha insertado en la Tabla AS_Incidencias la nueva Incidencia
    */
    public int insertInToIncidencias(Incidencia incidencia){
        int filasAfectadas=0;
        gestoraSentencias.getPreparedstatementInsertInToIncidencias().setString(1, incidencia.getMatriculaAvion()); //Si algo falla hacemos rollback
        gestoraSentencias.getPreparedstatementInsertInToIncidencias().setBigDecimal(2, incidencia.getLatitud());
        gestoraSentencias.getPreparedstatementInsertInToIncidencias().setBigDecimal(3, incidencia.getLongitud());
        gestoraSentencias.getPreparedstatementInsertInToIncidencias().setString(4, incidencia.getDescripcion());
        gestoraSentencias.getPreparedstatementInsertInToIncidencias().setString(5, incidencia.getTipo());
        filasAfectadas=gestoraSentencias.getPreparedstatementInsertInToIncidencias().executeUpdate();
        conexion.getConnect().commit();
        return filasAfectadas;
    }
  
    /*
    Proposito: Elimina el contenido de la table EX_Actualizaciones
    Precondiciones: No hay
    Entradas: no hay
    Salidas: no hay
    Postcondiciones: Se ha eliminado el contenido de EX_Actualizaciones
    */
    public void deleteActualizaciones(){     
        String delete="DELETE FROM EX_Actualizaciones";
        Statement sentencia;
        
        try {
            sentencia=conexion.getConnect().createStatement();
            sentencia.executeUpdate(delete);   
            conexion.getConnect().commit();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());   
            //Si algo falla hacemos rollback
            conexion.getConnect().rollback();
        }
    }


    
    
    
    
}
