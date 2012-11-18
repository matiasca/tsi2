package uy.com.arnaldocastro.servicedesk.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.serviciosweb.ICliente;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

public class UsuarioBean {

	private String cliente;
	private String email;

	private String value1;

	private String grupo;

	private SesionBean sesion;

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void crearUsuario(ActionEvent ae) {

		JSONObject respuesta = new IUsuario().crearUsuario(sesion.getTokenId(),
				cliente, email);

		String mensaje;
		try {
			if (respuesta.getInt("status") == -5){
				email="";
				cliente="";
				
				
				
			}
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void crearTecnico() {

		JSONObject respuesta = new IUsuario().crearTecnico(sesion.getTokenId(),
				email, grupo);
		String mensaje;
		try {
			if (respuesta.getInt("status") == -6){
				email="";
				grupo="";
				
				
				
			}
			
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void crearAdmin() {

		JSONObject respuesta = new IUsuario().crearAdmin(sesion.getTokenId(),
				email, grupo);
		String mensaje;
		try {
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			email = "";

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> listarTecnicos() {

		JSONObject respuesta = new IUsuario().listarTecnicos(sesion
				.getTokenId());
		JSONArray lista = null;
		try {

			lista = respuesta.getJSONArray("lista");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> aux = new ArrayList<String>();
		if (lista != null) {
			int len = lista.length();
			for (int i = 0; i < len; i++) {
				try {
					aux.add(lista.getJSONObject(i).getString("correo"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return aux;
	}

	public List<String> listarGrupos() {

		JSONObject respuesta = new IGrupo().listarGrupos(sesion.getTokenId());
		JSONArray lista = null;
		List<String> aux = new ArrayList<String>();
		try {

			lista = respuesta.getJSONArray("lista");
			if (lista != null) {
				int len = lista.length();
				for (int i = 0; i < len; i++) {

					aux.add(lista.getJSONObject(i).getJSONObject("grupo")
							.getString("nombre"));

				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	public List<String> listarGruposSinAdmin() {

		JSONObject respuesta = new IGrupo().listarGruposSinAdministrador(sesion.getTokenId());
		JSONArray lista = null;
		try {

			lista = respuesta.getJSONArray("lista");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> aux = new ArrayList<String>();
		if (lista != null) {
			int len = lista.length();
			for (int i = 0; i < len; i++) {
				try {
					aux.add(lista.getJSONObject(i).getJSONObject("grupo")
							.getString("nombre"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return aux;
	}
	
	public List<String> listarClientes() {

		JSONObject respuesta = new ICliente().listarCliente(sesion.getTokenId());
		JSONArray lista = null;
		try {

			lista = respuesta.getJSONArray("lista");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> aux = new ArrayList<String>();
		
		if (lista != null) {
			int len = lista.length();
			for (int i = 0; i < len; i++) {
				try {
					aux.add(lista.getString(i));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}else
			aux.clear();
		return aux;
	}

}