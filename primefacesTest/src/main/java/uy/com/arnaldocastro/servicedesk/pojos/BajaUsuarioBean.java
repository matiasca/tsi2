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

public class BajaUsuarioBean {

	List<NombreMail> listaUsuarios;
	List<String> listaClientes;
	private String cliente= "vacio";

	private NombreMail mailUsuario;

	private SesionBean sesion;

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public NombreMail getMailUsuario() {
		return mailUsuario;
	}

	public void setMailUsuario(NombreMail mailUsuario) {
		this.mailUsuario = mailUsuario;
	}

	
	public void listarUsuarios() {
		JSONArray lista = null;

		try {
			JSONObject respuesta = new IUsuario().listarUsuarios(sesion
					.getTokenId(),cliente);

			lista = respuesta.getJSONArray("lista");
			listaUsuarios = new ArrayList<NombreMail>();

			if (lista != null) {
				int len = lista.length();
				for (int i = 0; i < len; i++) {
					try {
						NombreMail nodo = new NombreMail();
						JSONObject ob = lista.getJSONObject(i);
						nodo.setMail(ob.getString("correo"));
						nodo.setNombre(ob.getString("nombre") + " "
								+ ob.getString("apellido"));
						listaUsuarios.add(nodo);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}else
				listaUsuarios.clear();
				
			

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<NombreMail> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<NombreMail> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public void borrarUsuario() {
	
		JSONObject respuesta = new IUsuario().bajaUsuarioCliente(sesion.getTokenId(),mailUsuario.getMail());
		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2){
				msg = new FacesMessage("Usuario borrado con exito", "");
				listarUsuarios();
			}else
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error al borrar usuario.", "");

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<String> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<String> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@PostConstruct
	public void listarClientes() {

		JSONObject respuesta = new ICliente().listarCliente(sesion.getTokenId());
		JSONArray lista = null;
		try {

			lista = respuesta.getJSONArray("lista");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		}else
			listaClientes.clear();
		
	}

}
