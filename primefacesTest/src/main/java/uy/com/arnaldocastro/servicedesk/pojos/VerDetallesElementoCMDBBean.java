package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.annotation.PostConstruct;
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


public class VerDetallesElementoCMDBBean {
	
	private SesionBean sesion;

	private String codigoElemento;
	private String descripcionElemento;
	private String ubicacionElemento;
	private List<FilaTablaHistorialElemento> historialElementoCMDB;
	private boolean historialVacio;
	
	public VerDetallesElementoCMDBBean() {
		historialElementoCMDB = new ArrayList<FilaTablaHistorialElemento>();
		historialVacio = false;
	}
	
	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}
	

	public boolean isHistorialVacio() {
		return historialVacio;
	}
	
	public void setHistorialVacio(boolean historialVacio) {
		this.historialVacio = historialVacio;
	}
	

	public String getCodigoElemento() {
		return codigoElemento;
	}

	public void setCodigoElemento(String codigoElemento) {
		this.codigoElemento = codigoElemento;
	}

	public String getDescripcionElemento() {
		return descripcionElemento;
	}

	public void setDescripcionElemento(String descripcionElemento) {
		this.descripcionElemento = descripcionElemento;
	}

	public String getUbicacionElemento() {
		return ubicacionElemento;
	}

	public void setUbicacionElemento(String ubicacionElemento) {
		this.ubicacionElemento = ubicacionElemento;
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

	

	@PostConstruct
	public void verDetalleElemento(){

		try {
		JSONObject respuesta = new ICMDB().verDetalleElemento(sesion.getTokenId(),sesion.getClienteCMDBselec(), sesion.getElemento().getCodigo());
		
		JSONObject elem = respuesta.getJSONObject("Elemento");
			 
			 codigoElemento = elem.getString("codigo");
			 descripcionElemento = elem.getString("descripcion");
			 ubicacionElemento = elem.getString("ubicacion");
			 
			 if (elem.has("cambios")){
				 
				 JSONArray lista = null;
					try {

						lista = elem.getJSONArray("cambios");

					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if (lista != null) {
						int len = lista.length();
						if (len > 0) {
							this.historialVacio = true;
						} else {
							this.historialVacio = false;
						}
						for (int i = 0; i < len; i++) {
							try {
								JSONObject ob = lista.getJSONObject(i);
								FilaTablaHistorialElemento hist = new FilaTablaHistorialElemento();
								
								String descripcion = ob.getString("descripcion");
								if (descripcion.length() > 20)
									descripcion = descripcion.substring(0, 20);
								hist.setDescr(descripcion);
								
								String f = ob.getString("fechaInicio");
								String dia = f.substring(8, 10);
								String mes = f.substring(5, 7);
								String anio = f.substring(0, 4);

								hist.setFecha(dia + "/" + mes + "/" + anio);

								hist.setResponsable(ob.getString("responsable"));
								historialElementoCMDB.add(hist);
								
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}				 
			 }
				 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void eliminarElementoCMDB(ActionEvent actionEvent){  

		JSONObject respuesta = new ICMDB().eliminarElemento(sesion.getTokenId(), sesion.getClienteCMDBselec(), sesion.getElemento().getCodigo());
		
		String mensaje;
		try {
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	
	public void modificarElementoCMDB(ActionEvent ae){
		
		JSONObject respuesta = new ICMDB().modificarElemento(sesion.getTokenId(), sesion.getClienteCMDBselec(),  sesion.getElemento().getCodigo(), descripcionElemento, ubicacionElemento);
		
		String mensaje;
		try {
		
				RequestContext.getCurrentInstance().execute("dialogoCMDBElementModificar.hide()");
				mensaje = respuesta.getString("mensaje");
				FacesMessage msg = new FacesMessage(mensaje, "");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<FilaTablaHistorialElemento> getHistorialElementoCMDB() {
		return historialElementoCMDB;
	}

	public void setHistorialElementoCMDB(List<FilaTablaHistorialElemento> historialElementoCMDB) {
		this.historialElementoCMDB = historialElementoCMDB;
	}
	
}
