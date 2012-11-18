package uy.com.arnaldocastro.servicedesk.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.event.SelectEvent;

import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICliente;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

public class BajaClienteBean {

	List<String> listaClientes;

	private String nombreCliente = "vacio";

	private SesionBean sesion;

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	@PostConstruct
	public void listarClientes() {

		JSONArray lista = null;

		try {
			JSONObject respuesta = new ICliente().listarCliente(sesion
					.getTokenId());

			lista = respuesta.getJSONArray("lista");
			listaClientes = new ArrayList<String>();

			
			if (lista != null) {
				int len = lista.length();
				for (int i = 0; i < len; i++) {
					try {
						listaClientes.add(lista.getString(i));
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} else
				listaClientes.clear();
			

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<String> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<String> getListaTecnicos() {
		return listaClientes;
	}

	public void setListaTecnicos(List<String> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void borrarCliente() {
	
		JSONObject respuesta = new ICliente().bajaCliente(sesion.getTokenId(),nombreCliente);
		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2){
				msg = new FacesMessage("Cliente borrado con exito", "");
				listaClientes.remove(nombreCliente);
				
			}else
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error al borrar cliente.", "");

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
