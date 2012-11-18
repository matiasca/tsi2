package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import uy.com.arnaldocastro.servicedesk.otros.FilaTablaElemento;
import uy.com.arnaldocastro.servicedesk.otros.FilaTablaHistorialElemento;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICMDB;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICliente;


public class GestionCMDBBean {
	
	private SesionBean sesion;
	
	private String cliente;
	private Boolean showCMDBElements;
	private List<FilaTablaElemento> listaElementosCMDBCLiente;
	private String selectedelem;

	//Datos de elemento nuevo
	private String codigoElementoNuevo;
	private String descripcionElementoNuevo;
	private String ubicacionElementoNuevo;
	
	public GestionCMDBBean() {
		showCMDBElements = false;
		listaElementosCMDBCLiente = new ArrayList<FilaTablaElemento>();
	}
	
	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Boolean getShowCMDBElements() {
		return showCMDBElements;
	}

	public void setShowCMDBElements(Boolean showCMDBElements) {
		this.showCMDBElements = showCMDBElements;
	}

	public List<FilaTablaElemento> getListaElementosCMDBCLiente() {
		return listaElementosCMDBCLiente;
	}

	public void setListaElementosCMDBCLiente(List<FilaTablaElemento> listaElementosCMDBCLiente) {
		this.listaElementosCMDBCLiente = listaElementosCMDBCLiente;
	}


	public String getSelectedelem() {
		return selectedelem;
	}

	public void setSelectedelem(String selectedelem) {
		this.selectedelem = selectedelem;
	}

	
	public void irVerDetalles(SelectEvent event) {
			
		
		sesion.setClienteCMDBselec(cliente);
			
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("verDetalleElementoCMDB.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public List<String> listarClientes(){
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
		}
		return aux;
	}

	public String getCodigoElementoNuevo() {
		return codigoElementoNuevo;
	}

	public void setCodigoElementoNuevo(String codigoElementoNuevo) {
		this.codigoElementoNuevo = codigoElementoNuevo;
	}

	public String getDescripcionElementoNuevo() {
		return descripcionElementoNuevo;
	}

	public void setDescripcionElementoNuevo(String descripcionElementoNuevo) {
		this.descripcionElementoNuevo = descripcionElementoNuevo;
	}

	public String getUbicacionElementoNuevo() {
		return ubicacionElementoNuevo;
	}

	public void setUbicacionElementoNuevo(String ubicacionElementoNuevo) {
		this.ubicacionElementoNuevo = ubicacionElementoNuevo;
	}

	public void actualizarDatostabla(){
		showCMDBElements = true;
		listaElementosCMDBCLiente.clear();
		
		JSONObject respuesta = new ICMDB().listarElementos(sesion.getTokenId(),cliente);
		JSONArray lista = null;
		try {

			lista = respuesta.getJSONArray("listaElementos");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (lista != null) {
			int len = lista.length();
			for (int i = 0; i < len; i++) {
				try {
					JSONObject ob = lista.getJSONObject(i); 
					FilaTablaElemento elem  = new FilaTablaElemento();
					elem.setCodigo(ob.getString("codigo"));
					elem.setDescripcion(ob.getString("descripcion"));
					elem.setUbicacion(ob.getString("ubicacion"));
					listaElementosCMDBCLiente.add(elem);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		
	}
	
	public void agragarElementoCMDB(ActionEvent ae){
	
		JSONObject respuesta = new ICMDB().crearElemento(sesion.getTokenId(), cliente, codigoElementoNuevo, descripcionElementoNuevo, ubicacionElementoNuevo);
		
		String mensaje;
		try {
			
			
			mensaje = respuesta.getString("mensaje");
			int status = respuesta.getInt("status");
			if(status==-9){
				RequestContext.getCurrentInstance().execute("dialogoCMDBElementAgregar.hide()");
				actualizarDatostabla();
				
				codigoElementoNuevo="";
				descripcionElementoNuevo="";
				ubicacionElementoNuevo="";
			
			}
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
