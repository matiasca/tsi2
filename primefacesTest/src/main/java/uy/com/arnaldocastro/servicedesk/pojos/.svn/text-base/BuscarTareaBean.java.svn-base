package uy.com.arnaldocastro.servicedesk.pojos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.event.SelectEvent;

import uy.com.arnaldocastro.servicedesk.otros.FilaTablaTarea;
import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICliente;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ITarea;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

public class BuscarTareaBean {

	

	private String cadena ;
	private SesionBean sesion;
	
	
	private List<FilaTablaTarea> listaTareas;

	
	public String getCadena() {
		return cadena;
	}




	public void setCadena(String cadena) {
		this.cadena = cadena;
	}




	public List<FilaTablaTarea> getListaTareas() {
		return listaTareas;
	}




	public void setListaTareas(List<FilaTablaTarea> listaTareas) {
		this.listaTareas = listaTareas;
	}




	public String getBusca() {
		return cadena;
	}




	public void setBusca(String cadena) {
		this.cadena = cadena;
	}




	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}




	public String buscarTarea() {
		
		JSONObject respuesta = new ITarea().buscarTarea(sesion.getTokenId(), cadena);
		
		System.out.println("DEL BUSCARRRRRR"+respuesta);
		JSONArray lista = null;
		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2){
				
				
				
				
				
				
				lista = respuesta.getJSONArray("lista");
				listaTareas = new ArrayList<FilaTablaTarea>();
				if (lista != null) {

					for (int i = 0; i < lista.length(); i++) {

						JSONObject ob = lista.getJSONObject(i);
						FilaTablaTarea tarea = new FilaTablaTarea();

						String asunto = ob.getString("asunto");
						if (asunto.length() > 20)
							tarea.setAsunto(asunto.substring(0, 20));
						else
							tarea.setAsunto(asunto);

						if (ob.has("cliente"))
							tarea.setCliente(ob.getJSONObject("cliente").getString(
									"nombre"));

						String estado = ob.getString("estado");
						estado = estado.substring(0, 1)
								+ estado.substring(1).toLowerCase();
						tarea.setEstado(estado);

						String f = ob.getString("fechaInicio");
						String dia = f.substring(8, 10);
						String mes = f.substring(5, 7);
						String anio = f.substring(0, 4);

						tarea.setFecha(dia + "/" + mes + "/" + anio);

						tarea.setId(ob.getInt("id"));
						int p = ob.getInt("prioridad");
						if (p == 1)
							tarea.setPrioridad("Alta");
						else if (p == 2)
							tarea.setPrioridad("Media");
						else
							tarea.setPrioridad("Baja");

						String responsable = "";
						if (ob.has("responsable")) {
							JSONObject resp = ob.getJSONObject("responsable");
							if (resp.has("nombre"))
								responsable = resp.getString("nombre") + " "
										+ resp.getString("apellido");
							else if (resp.has("mail"))
								responsable = resp.getString("correo");
						} else
							responsable = "Sin asignar";
						
						tarea.setResponsable(responsable);
						listaTareas.add(tarea);

					}

				}
				
				
				
				
				
				
				msg = new FacesMessage("Búsqueda con realizada", "");
				
				
			}else
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error en la búsqueda.", "");

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Collections.reverse(listaTareas);
		
		return "buscarTarea";
	}

	


}
