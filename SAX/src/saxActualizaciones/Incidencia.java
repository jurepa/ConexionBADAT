/*
 * Propiedades b�sicas:
 * 		Matricula avion: Cadena, Consultable, Modificable
 * 		Descripcion: Cadena, Consultable, Modificable
 * 		Tipo: Cadena, Consultable, Modificable
 * 
 * Propiedades Agregadas:
 * 		Latitud: java.math.BigDecimal
 * 		Longitud: java.math.BigDecimal
 * 
 * */
public class Incidencia {
	
	//Propiedades
	private String matriculaAvion;
	private java.math.BigDecimal latitud;
	private java.math.BigDecimal longitud;
	private String descripcion;
	private String tipo;
	
	
	//Contructores
	public Incidencia() {
		matriculaAvion="";
		latitud=new java.math.BigDecimal(0.0);
		longitud=new java.math.BigDecimal(0.0);
		descripcion="";
		tipo="";
	}
	
	public Incidencia(String matriculaAvion, java.math.BigDecimal latitud, java.math.BigDecimal longitud, String descripcion, String tipo){
		this.matriculaAvion=matriculaAvion;
		this.latitud=latitud;
		this.longitud=longitud;
		this.descripcion=descripcion;
		this.tipo=tipo;
	}

	//Getters and Setters
	public String getMatriculaAvion() {
		return matriculaAvion;
	}


	public void setMatriculaAvion(String matriculaAvion) {
		this.matriculaAvion = matriculaAvion;
	}


	public java.math.BigDecimal getLatitud() {
		return latitud;
	}


	public void setLatitud(java.math.BigDecimal latitud) {
		this.latitud = latitud;
	}


	public java.math.BigDecimal getLongitud() {
		return longitud;
	}


	public void setLongitud(java.math.BigDecimal longitud) {
		this.longitud = longitud;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	
	
}
