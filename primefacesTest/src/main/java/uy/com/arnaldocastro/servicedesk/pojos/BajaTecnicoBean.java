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

public class BajaTecnicoBean {

	List<NombreMail> listaTecnicos;

	private NombreMail mailTecnico;
	

	private SesionBean sesion;

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public NombreMail getMailTecnico() {
		return mailTecnico;
	}

	

	public void setMailTecnico(NombreMail mailTecnico) {
		this.mailTecnico = mailTecnico;
	}

	@PostConstruct
	public void listarTecnicos() {

		JSONArray lista = null;

		try {
			JSONObject respuesta = new IUsuario().listarTecnicos(sesion
					.getTokenId());

			lista = respuesta.getJSONArray("lista");
			listaTecnicos = new ArrayList<NombreMail>();

			if (lista != null) {
				int len = lista.length();
				for (int i = 0; i < len; i++) {
					try {
						NombreMail nodo = new NombreMail();
						JSONObject ob = lista.getJSONObject(i);
						nodo.setMail(ob.getString("correo"));
						nodo.setNombre(ob.getString("nombre") + " "
								+ ob.getString("apellido"));
						listaTecnicos.add(nodo);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<NombreMail> getListaTecnicos() {
		return listaTecnicos;
	}

	public void setListaTecnicos(List<NombreMail> listaTecnicos) {
		this.listaTecnicos = listaTecnicos;
	}

	public void borrarTecnico() {
	
		JSONObject respuesta = new IUsuario().bajaTecnico(sesion.getTokenId(),mailTecnico.getMail());
		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2){
				msg = new FacesMessage("Tecnico borrado con exito", "");
				listarTecnicos();
			
			}else
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error al borrar tecnico.", "");

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
