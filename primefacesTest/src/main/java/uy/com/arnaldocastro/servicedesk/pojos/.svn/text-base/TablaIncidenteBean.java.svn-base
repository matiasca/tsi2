package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.UnselectEvent;

import uy.com.arnaldocastro.servicedesk.otros.FilaTablaIncidente;
import uy.com.arnaldocastro.servicedesk.otros.FilaTablaTarea;
import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IArchivo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ITarea;

public class TablaIncidenteBean implements Serializable {

	private String fecha = "";
	private String asunto = "";
	private String estado = "";
	private String selectedTab;
	private int id;

	private SesionBean sesion;
	private static final long serialVersionUID = 1L;
	private List<FilaTablaIncidente> incidentes;
	private FilaTablaIncidente incidenteSeleccionado;

	private int incidenteSeleccionadoid;

	public int getIncidenteSeleccionadoid() {
		return incidenteSeleccionadoid;
	}

	public void setIncidenteSeleccionadoid(int incidenteSeleccionadoid) {
		this.incidenteSeleccionadoid = incidenteSeleccionadoid;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public TablaIncidenteBean() {
	}

	public List<FilaTablaIncidente> getIncidentes() {
		return incidentes;
	}

	public void setIncidentes(List<FilaTablaIncidente> incidentes) {
		this.incidentes = incidentes;
	}

	public FilaTablaIncidente getIncidenteSeleccionado() {
		return incidenteSeleccionado;
	}

	public void setIncidenteSeleccionado(
			FilaTablaIncidente incidenteSeleccionado) {
		System.out.println("selecionaaaa");
		this.incidenteSeleccionado = incidenteSeleccionado;

	}

	public void incidentes() {

	}

	public void onRowSelect(SelectEvent event) {
		incidenteSeleccionado = (FilaTablaIncidente) event.getObject();
		System.out.println("**************" + incidenteSeleccionado
				+ "*******************");
	}

	public void abrirDialogo(SelectEvent event) {

	}

	public String getSelectedTab() {
		// selectedTab is a variable that should be set onTabChange()
		return selectedTab;
	}

	@PostConstruct
	public void listarIncidentes() {

		incidentes = new ArrayList<FilaTablaIncidente>();

		JSONObject respuesta = new ITarea().listarTareas(sesion.getTokenId(),
				sesion.getMail(), sesion.getMail(), "", "", "", "", "", "", "",
				"", "");

		JSONArray lista = null;
		try {
			incidentes = new ArrayList<FilaTablaIncidente>();

			lista = respuesta.getJSONArray("lista");

			if (lista != null) {

				for (int i = 0; i < lista.length(); i++) {

					JSONObject ob = lista.getJSONObject(i);
					FilaTablaIncidente tarea = new FilaTablaIncidente();
					tarea.setAsunto(ob.getString("asunto"));

					String estadoIncidente = ob.getString("estado");

					if (estadoIncidente.equals("INGRESADA")
							|| estadoIncidente.equals("ASIGNADA"))
						estadoIncidente = "Pendiente";
					else if (estadoIncidente.equals("PENDIENTE"))
						estadoIncidente = "Informacion requerida";
					else if (estadoIncidente.equals("CANCELADA"))
						estadoIncidente = "Cancelado";
					else if (estadoIncidente.equals("SOLUCIONADA")
							|| estadoIncidente.equals("FINALIZADA"))
						estadoIncidente = "Solucionado";

					tarea.setDescripcion(ob.getString("descripcion"));

					tarea.setEstado(estadoIncidente);

					String f = ob.getString("fechaInicio");
					String dia = f.substring(8, 10);
					String mes = f.substring(5, 7);
					String anio = f.substring(0, 4);

					tarea.setFecha(dia + "/" + mes + "/" + anio);
					tarea.setId(ob.getInt("id"));
					incidentes.add(tarea);

				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Collections.reverse(incidentes);

	}

	public void cancelarIncidente() {

		System.out.println("cancelooooooooooooawdawdawdoooooooooo"
				+ incidenteSeleccionadoid);

		
	

		JSONObject respuesta = new ITarea().cancelarIncidentePorUsuarioFinal(
				sesion.getTokenId(), incidenteSeleccionadoid);

		String mensaje;
		try {
			
			
			mensaje = respuesta.getString("mensaje");
			int status=respuesta.getInt("status");
			if(status==2){
				Iterator<FilaTablaIncidente> it = incidentes.iterator();

				boolean encontre = false;
				FilaTablaIncidente fila = null;
				while (it.hasNext() && (!encontre)) {
					 fila = it.next();

					if (fila.getId() == incidenteSeleccionadoid)
					encontre = true;
				}
				fila.setEstado("Cancelado");
				
			
				
			}
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}