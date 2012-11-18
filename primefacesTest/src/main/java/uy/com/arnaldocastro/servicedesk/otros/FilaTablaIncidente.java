package uy.com.arnaldocastro.servicedesk.otros;

import java.io.Serializable;

public class FilaTablaIncidente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecha;
	private String asunto;
	private String estado;
	
	private int id; //no se muestra en la tabla pero se necesita para saber cual fue la tarea seleccionada
	
	private String descripcion;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FilaTablaIncidente() {
		
	}
	public FilaTablaIncidente(int id,String fecha, String asunto, String estado) {
		this.id=id;
		this.fecha = fecha;
		this.asunto = asunto;
		this.estado = estado;
	
	}
	
	public FilaTablaIncidente(String fecha, String asunto, String estado) {
		
		this.fecha = fecha;
		this.asunto = asunto;
		this.estado = estado;
	
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
