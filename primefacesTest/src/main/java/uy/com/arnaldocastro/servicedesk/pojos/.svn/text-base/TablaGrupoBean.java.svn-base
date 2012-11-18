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


import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;

public class TablaGrupoBean {

	private String nombre;
	private String admin;
	
	
	private List<NombreMail> listaAdministradores;

	private List<NombreMail> dropeddtecnicosSinGrupo;
	private List<NombreMail> tecnicosSinGrupo;

	
	private SesionBean sesion;
	

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}
	public TablaGrupoBean() {
		
		listaAdministradores = new ArrayList<NombreMail>();
		tecnicosSinGrupo = new ArrayList<NombreMail>();
		dropeddtecnicosSinGrupo = new ArrayList<NombreMail>();

		
	}


	public List<NombreMail> getDropeddtecnicosSinGrupo() {
		return dropeddtecnicosSinGrupo;
	}

	public void setDropeddtecnicosSinGrupo(	List<NombreMail> dropeddtecnicosSinGrupo) {
		this.dropeddtecnicosSinGrupo = dropeddtecnicosSinGrupo;
	}

	public List<NombreMail> gettecnicosSinGrupo() {
		return tecnicosSinGrupo;
	}

	public void settecnicosSinGrupo(List<NombreMail> tecnicosSinGrupo) {
		this.tecnicosSinGrupo = tecnicosSinGrupo;
	}

	public void onTecDrop(DragDropEvent ddEvent) {
		NombreMail tec = ((NombreMail) ddEvent.getData());
		if (!dropeddtecnicosSinGrupo.contains(tec)) {
			dropeddtecnicosSinGrupo.add(tec);
			tecnicosSinGrupo.remove(tec);
		}
	}

	public void onTecDrop2(DragDropEvent ddEvent) {
		NombreMail tec = ((NombreMail) ddEvent.getData());
		if (!tecnicosSinGrupo.contains(tec)) {
			tecnicosSinGrupo.add(tec);
			dropeddtecnicosSinGrupo.remove(tec);
		}
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<NombreMail> getListaAdministradores() {
		return listaAdministradores;
	}

	public void setListaAdministradores(List<NombreMail> listaAdministradores) {
		this.listaAdministradores = listaAdministradores;
	}


	public  List<NombreMail> listarAdministradores() {

		listaAdministradores.clear();
		
		JSONObject respuesta = new IGrupo().listarAdministradoresSinGrupo(sesion.getTokenId());

		JSONArray admins = null;
		try {
			
			admins = respuesta.getJSONArray("lista");
			if (admins != null) {

				for (int i = 0; i < admins.length(); i++) {

					JSONObject ob = admins.getJSONObject(i);
					NombreMail b = new NombreMail();
					b.setMail(ob.getString("correo"));
					b.setNombre(ob.getString("nombre") + " " + ob.getString("apellido"));
					listaAdministradores.add(b);

				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaAdministradores;
	}

	@PostConstruct
	public void listartecnicosSinGrupo() {

		JSONObject respuesta = new IGrupo().listartecnicosSinGrupo(sesion.getTokenId());

		JSONArray tecnicos = null;
		try {

			tecnicos = respuesta.getJSONArray("lista");
			if (tecnicos != null) {

				for (int i = 0; i < tecnicos.length(); i++) {

					JSONObject ob = tecnicos.getJSONObject(i);
					NombreMail b = new NombreMail();
					b.setMail(ob.getString("correo"));
					b.setNombre(ob.getString("nombre") + " " + ob.getString("apellido"));
					tecnicosSinGrupo.add(b);

				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void crearGrupo() {

		List<String> tecnicosSinGrupoMail = new ArrayList<String>();
		
		for (int i = 0; i < dropeddtecnicosSinGrupo.size(); i++) {
			tecnicosSinGrupoMail.add(dropeddtecnicosSinGrupo.get(i).getMail());
			System.out.println("tecnico "+ i + tecnicosSinGrupoMail.get(i));
		}
		
		System.out.println("admin "+ admin);
		JSONObject respuesta = new IGrupo().crearGrupo(sesion.getTokenId(),nombre, admin,tecnicosSinGrupoMail);
		String mensaje;
		try {
			
			
			if (respuesta.getInt("status") ==2){
				
				nombre="";
				admin="";
				
				listaAdministradores = new ArrayList<NombreMail>();
				tecnicosSinGrupo = new ArrayList<NombreMail>();
			
				listarAdministradores();
				listartecnicosSinGrupo();
				dropeddtecnicosSinGrupo = new ArrayList<NombreMail>();
			

				
				
			}
			
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}