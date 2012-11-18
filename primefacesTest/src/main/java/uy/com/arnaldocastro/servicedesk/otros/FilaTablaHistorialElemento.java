package uy.com.arnaldocastro.servicedesk.otros;

import java.io.Serializable;

public class FilaTablaHistorialElemento implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String fecha;
	private String responsable;
	private String descr;
	
	
	
	public FilaTablaHistorialElemento() {
		
	}
	
	public FilaTablaHistorialElemento(String fecha, String responsable, String descr) {
		super();
		this.fecha = fecha;
		this.responsable = responsable;
		this.descr = descr;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
