package uy.com.arnaldocastro.servicedesk.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.serviciosweb.ICategoria;


public class CategoriaBean {

	private String nombre;
	private String nombreNuevo;
	private SesionBean sesion;
	

	public String getNombreNuevo() {
		return nombreNuevo;
	}

	public void setNombreNuevo(String nombreNuevo) {
		this.nombreNuevo = nombreNuevo;
	}

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void crearCategoria(){
		
		JSONObject respuesta = new ICategoria().crearCategoria(sesion.getTokenId(),nombre);

		String mensaje;
		try {
			
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje,"");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void renombrarCategoria(){
		
		JSONObject respuesta = new ICategoria().renombrarCategoria(sesion.getTokenId(),nombre,nombreNuevo);

		String mensaje;
		try {
			
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje,"");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> listarCategorias() {

		JSONObject respuesta = new ICategoria().listarCategorias(sesion.getTokenId());
		JSONArray lista = null;
		try {

			lista = respuesta.getJSONArray("listaCategorias");

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
		}
		return aux;
	}
}
