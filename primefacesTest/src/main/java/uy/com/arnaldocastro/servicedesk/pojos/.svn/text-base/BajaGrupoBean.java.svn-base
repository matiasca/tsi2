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

public class BajaGrupoBean {

	List<String> listaGrupos;

	private String nombreGrupo;

	private SesionBean sesion;

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	@PostConstruct
	public void listarGrupos() {

		JSONArray lista = null;

		try {
			JSONObject respuesta = new IGrupo().listarGrupos(sesion
					.getTokenId());

			lista = respuesta.getJSONArray("lista");
			listaGrupos = new ArrayList<String>();

			
			if (lista != null) {
				int len = lista.length();
				for (int i = 0; i < len; i++) {
					try {
						JSONObject ob = lista.getJSONObject(i);
						JSONObject ob2 = ob.getJSONObject("grupo");
						listaGrupos.add(ob2.getString("nombre"));
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} else
				listaGrupos.clear();
			

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public void setListaGrupos(List<String> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<String> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupoos(List<String> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public void borrarGrupo() {
	
		JSONObject respuesta = new IGrupo().bajaGrupo(sesion.getTokenId(),nombreGrupo);
		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2){
				msg = new FacesMessage("Grupo borrado con exito", "");
				
				listaGrupos.remove(nombreGrupo);
			}
			else
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error al borrar grupo.", "");

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
