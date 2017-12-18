import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GestoraSentencias {

	//Propiedades
	private PreparedStatement preparedStatementSelectIdFabricante;
	private CallableStatement callableStatementExecBajaAvion;
	private PreparedStatement preparedstatementInsertInToIncidencias;
	private Statement sentenciaResultSetActualizable;
	
	//Getters
	public PreparedStatement getPreparedStatementSelectIdFabricante() {
		return preparedStatementSelectIdFabricante;
	}


	public CallableStatement getCallableStatementExecBajaAvion() {
		return callableStatementExecBajaAvion;
	}


	public PreparedStatement getPreparedstatementInsertInToIncidencias() {
		return preparedstatementInsertInToIncidencias;
	}

	public Statement getSentenciaResultSetActualizable() {
		return sentenciaResultSetActualizable;
	}

	
    /*
    Proposito: Carga un ResultSet Actualizable con el contenido de AS_Aviones
    Precondiciones: No hay
    Entradas: No hay
    Salidas: Un ResultSet con el contenido de AS_Aviones
    Postcondiciones: Se ha cargado en un ResultSet el contenido de la tabla AS_Aviones
    */
	public ResultSet getResultSetActualizable() {
		ResultSet resultSetAct=null;
		try {
			resultSetAct=sentenciaResultSetActualizable.executeQuery("Select Matricula, Nombre, ID_Fabricante, Modelo, Fecha_Fabricacion, Fecha_Entrada, Filas, Asientos_x_Fila, Autonomia, Activo From AS_Aviones");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return resultSetAct;
	}

    /*
    Proposito: Prepara las sentencias
    Precondiciones: La conexion debe estar abierta
    Entradas: Un objeto GestoraConexion que ser� la conexi�n que se usar� para preparar las sentencias
    Salidas: No hay
    Postcondiciones: Se han preparado las sentencias
    */
	public void preparaSentencias(GestoraConexion conexion){
		try {
			preparedStatementSelectIdFabricante=conexion.getConnect().prepareStatement("SELECT ID_Fabricante FROM AS_Fabricantes where Nombre=?");
			callableStatementExecBajaAvion=conexion.getConnect().prepareCall("exec BajaAvion ?");
			preparedstatementInsertInToIncidencias=conexion.getConnect().prepareStatement("insert INTO AS_Incidencias (Avion, Latitud, Longitud, Descripcion, Tipo) values( ?, ?, ?, ?, ?)");
			sentenciaResultSetActualizable=conexion.getConnect().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	
}
