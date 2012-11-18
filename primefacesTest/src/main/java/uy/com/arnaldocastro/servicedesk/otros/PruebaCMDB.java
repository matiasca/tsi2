package uy.com.arnaldocastro.servicedesk.otros;

import java.io.Serializable;

public class PruebaCMDB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String descr;
	
	
	
	public PruebaCMDB() {
		
	}
	public PruebaCMDB(String descr) {
		super();
		this.descr = descr;
	}
	public String geDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
}
