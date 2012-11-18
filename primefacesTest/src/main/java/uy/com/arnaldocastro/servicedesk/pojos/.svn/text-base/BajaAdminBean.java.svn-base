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

public class BajaAdminBean {

	List<NombreMail> listaAdministradores = new ArrayList<NombreMail>();

	private NombreMail mailAdmin ;

	private SesionBean sesion;

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public NombreMail getMailAdmin() {
		return mailAdmin;
	}

	public void setMailAdmin(NombreMail mailAdmin) {
		this.mailAdmin = mailAdmin;
	}

	@PostConstruct
	public void listarAdministradores() {

		JSONArray lista = null;

		try {
			JSONObject respuesta = new IUsuario().listarAdministradores(sesion
					.getTokenId());

			lista = respuesta.getJSONArray("lista");
			listaAdministradores.clear();

			if (lista != null) {
				int len = lista.length();
				for (int i = 0; i < len; i++) {
					try {
						NombreMail nodo = new NombreMail();
						JSONObject ob = lista.getJSONObject(i);
						nodo.setMail(ob.getString("correo"));
						nodo.setNombre(ob.getString("nombre") + " "
								+ ob.getString("apellido"));
						listaAdministradores.add(nodo);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
			System.out.println("tammmmmmmmmmmmm " + listaAdministradores.size());
		

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<NombreMail> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(List<NombreMail> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	public void borrarAdministrador() {
		
		JSONObject respuesta = new IUsuario().bajaAdministrador(sesion.getTokenId(),mailAdmin.getMail());
		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2){
				msg = new FacesMessage("Tecnico borrado con exito", "");
				
				listarAdministradores();
			
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
