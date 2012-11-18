package uy.com.arnaldocastro.servicedesk.pojos;

import uy.com.arnaldocastro.servicedesk.otros.FilaTablaElemento;

public class SesionBean {

	private String tokenId;
	private String mail;
	private String nombre;
	private String tipoUsuario;
	private boolean nuevoUsuario;
	private boolean logueado=false;
	

	private int idTarea;

	
	private FilaTablaElemento elemento;
	

	private String clienteCMDBselec;

	public String getClienteCMDBselec() {
		return clienteCMDBselec;
	}

	public void setClienteCMDBselec(String clienteCMDBselec) {
		this.clienteCMDBselec = clienteCMDBselec;
	}

	public FilaTablaElemento getElemento() {
		return elemento;
	}

	public void setElemento(FilaTablaElemento elemento) {

		this.elemento = elemento;
	}

	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public int getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public boolean esAcsaUsuario() {

		return (tipoUsuario.equals("Administrador")
				|| tipoUsuario.equals("SuperAdministrador") || tipoUsuario
					.equals("Tecnico"));

	}

	public String mostrarMenu() {

		String src = "";
		if (tipoUsuario.equals("SuperAdministrador"))
			src = "/menuPrincipalSuperAdmin.xhtml";
		else if (tipoUsuario.equals("Administrador"))
			src = "/menuPrincipalAdministrador.xhtml";
		else if (tipoUsuario.equals("Tecnico"))
			src = "/menuPrincipalTecnico.xhtml";

		return src;
	}

	public boolean isNuevoUsuario() {
		return nuevoUsuario;
	}

	public void setNuevoUsuario(boolean nuevoUsuario) {
		this.nuevoUsuario = nuevoUsuario;
	}

	public String  perfil() {
		if (tipoUsuario.equals("Administrador") || tipoUsuario.equals("SuperAdministrador") || tipoUsuario.equals("Tecnico"))
				return "perfilTecnico";
		else
			return "perfilUsuario";					
	}
	
	
}
