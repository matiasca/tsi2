package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cliente implements Serializable {

	private int codigo;
	private String nombre;
	private String direccion;
	private String tipoCliente; // N:Natural J:juridica
	private String documento;
	private String telefono;

	public Cliente() {
	}

	public Cliente(int codigo, String nombre, String direccion,
			String tipoCliente, String documento, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tipoCliente = tipoCliente;
		this.documento = documento;
		this.telefono = telefono;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}