package uy.com.arnaldocastro.servicedesk.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.SelectEvent;

import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICliente;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

public class ModificarGrupoBean {

	List<NombreMail> listaTecnicosGrupo = new ArrayList<NombreMail>();
	List<NombreMail> listaRestoTecnicos = new ArrayList<NombreMail>();
	List<NombreMail> listaAdministradores = new ArrayList<NombreMail>();
	List<String> listaGrupos = new ArrayList<String>();

	private String grupoSeleccionado = "grupo vacio";
	private String nuevoNombreGrupo;

	private String nuevoAdministrador;
	private String admin = "admin vacio";

	private SesionBean sesion;

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	@PostConstruct
	public void listarGrupos() {

		JSONArray lista = null;
		try {
			JSONObject respuesta = new IGrupo().listarGrupos(sesion
					.getTokenId());

			lista = respuesta.getJSONArray("lista");
			listaGrupos.clear();
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

			} else {
				listaGrupos.clear();

			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public List<NombreMail> listarAdministradores() {

		JSONObject respuesta = new IGrupo()
				.listarAdministradores(sesion.getTokenId());

		JSONArray admins = null;
		listaAdministradores.clear();
		try {

			admins = respuesta.getJSONArray("lista");
			if (admins != null) {

				for (int i = 0; i < admins.length(); i++) {

					JSONObject ob = admins.getJSONObject(i);
					NombreMail b = new NombreMail();
					b.setMail(ob.getString("correo"));
					b.setNombre(ob.getString("nombre") + " "
							+ ob.getString("apellido"));
					listaAdministradores.add(b);
				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAdministradores;

	}

	public void cargarDatosGrupo() {

		JSONObject respuesta = new IGrupo().listarMiembrosDeGrupo(
				sesion.getTokenId(), grupoSeleccionado);
		JSONObject respuesta2 = new IGrupo().tecnicosFueraDelGrupo(
				sesion.getTokenId(), grupoSeleccionado);
		try {

			if (respuesta.has("jefe")) {
				JSONObject objetoJefe = respuesta.getJSONObject("jefe");
				nuevoAdministrador = objetoJefe.getString("nombre") + " "
						+ objetoJefe.getString("apellido");
				if (!objetoJefe.getString("nombre").equals(""))
					nuevoAdministrador = nuevoAdministrador + " - ";
				nuevoAdministrador = nuevoAdministrador
						+ objetoJefe.getString("correo");
			} else
				nuevoAdministrador = "No tiene administrador.";

			listaTecnicosGrupo.clear();
			JSONArray objetoIntegantes = respuesta.getJSONArray("grupo");
			if (objetoIntegantes != null) {
				for (int i = 0; i < objetoIntegantes.length(); i++) {
					JSONObject ob = objetoIntegantes.getJSONObject(i);
					NombreMail b = new NombreMail();
					b.setMail(ob.getString("correo"));
					b.setNombre(ob.getString("nombre") + " "
							+ ob.getString("apellido"));
					listaTecnicosGrupo.add(b);
				}
			}

			listaRestoTecnicos.clear();
			JSONArray objetoTecnicos = respuesta2.getJSONArray("Tecnicos");

			if (objetoTecnicos != null) {
				for (int i = 0; i < objetoTecnicos.length(); i++) {
					JSONObject ob = objetoTecnicos.getJSONObject(i);
					NombreMail b = new NombreMail();
					b.setMail(ob.getString("correo"));
					b.setNombre(ob.getString("nombre") + " "
							+ ob.getString("apellido"));
					listaRestoTecnicos.add(b);
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void guardarCambiosGrupo(){
		
		JSONArray lista = new JSONArray();
		
		for (int i = 0; i < listaTecnicosGrupo.size(); i++) {		
			lista.put(listaTecnicosGrupo.get(i).getMail());
		}
		
		JSONObject respuesta = new IGrupo().modificiarGrupo(sesion.getTokenId(), grupoSeleccionado, nuevoNombreGrupo, lista,parsearMail(nuevoAdministrador));
		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2){
				msg = new FacesMessage("Grupo modificado con exito", "");
				listarGrupos();
			}else
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error al modificar grupo.", "");

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				
	}

	public List<NombreMail> getListaTecnicosGrupo() {
		return listaTecnicosGrupo;
	}

	public void setListaTecnicosGrupo(List<NombreMail> listaTecnicosGrupo) {
		this.listaTecnicosGrupo = listaTecnicosGrupo;
	}

	public List<NombreMail> getListaRestoTecnicos() {
		return listaRestoTecnicos;
	}

	public String getNuevoNombreGrupo() {
		return nuevoNombreGrupo;
	}

	public void setNuevoNombreGrupo(String nuevoNombreGrupo) {
		this.nuevoNombreGrupo = nuevoNombreGrupo;
	}

	public void setListaRestoTecnicos(List<NombreMail> listaRestoTecnicos) {
		this.listaRestoTecnicos = listaRestoTecnicos;
	}

	public List<String> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<String> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public String getGrupoSeleccionado() {
		return grupoSeleccionado;
	}

	public void setGrupoSeleccionado(String grupoSeleccionado) {
		this.grupoSeleccionado = grupoSeleccionado;
		this.nuevoNombreGrupo = grupoSeleccionado;
	}

	public String getNuevoAdministrador() {
		return nuevoAdministrador;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public void setNuevoAdministrador(String nuevoAdministrador) {
		this.nuevoAdministrador = nuevoAdministrador;
	}

	public List<NombreMail> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(List<NombreMail> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}

	public void onTecDrop2(DragDropEvent ddEvent) {	
		NombreMail tec = ((NombreMail) ddEvent.getData());
		if (!listaTecnicosGrupo.contains(tec)) {
			listaTecnicosGrupo.add(tec);
			listaRestoTecnicos.remove(tec);			
		}		
	}

	public void onTecDrop(DragDropEvent ddEvent) {	
		NombreMail tec = ((NombreMail) ddEvent.getData());
		if (!listaRestoTecnicos.contains(tec)) {
			listaRestoTecnicos.add(tec);
			listaTecnicosGrupo.remove(tec);	
		}
	}
	
	public String parsearMail(String cadena){
		int pos = cadena.indexOf("- ");
		if ( pos != -1){			
			String mail =  cadena.substring(pos+2, cadena.length());
			System.out.println("|"+mail+"|");
			return mail;
		}else
			return cadena;
	}

}
