package uy.com.arnaldocastro.servicedesk.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

import uy.com.arnaldocastro.servicedesk.otros.FilaTablaElemento;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IArchivo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICMDB;

public class CambioElementoBean {

	private String elemento;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin = new Date();
	private SesionBean sesion;
	private DetalleTareaBean detalleTarea;
	private byte[] archivo;
	private String nombreArchivo;
	private List<FilaTablaElemento> listaElementos;
	
	
	public List<FilaTablaElemento> getListaElementos() {
		System.out.println("getter de la lista podrida");
		System.out.println(listaElementos);
		return listaElementos;
	}
	public void setListaElementos(List<FilaTablaElemento> listaElementos) {
		System.out.println("en el setter de la lista podrida");
		this.listaElementos = listaElementos;
	}
	public SesionBean getSesion() {
		return sesion;
	}
	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}
	public String getElemento() {
		return elemento;
	}
	public void setElemento(String elemento) {
		this.elemento = elemento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public void listarElementos(){
		
		listaElementos = new ArrayList<FilaTablaElemento>();
		JSONObject respuesta = new ICMDB().listarElementos(sesion.getTokenId(),detalleTarea.getCliente());
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
					listaElementos.add(elem);
					System.out.println("agregue");
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		
	}
	
	public void uploadArchivo(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage(event.getFile().getFileName() + " fue subido con éxito.","");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		archivo=event.getFile().getContents();
		nombreArchivo=event.getFile().getFileName();

	}
	
	public String crearCambio(){
		
		String salida="";
		if (fechaInicio.before(fechaFin)){
			JSONObject respuesta = new ICMDB().agregarCambioElemento(sesion.getTokenId(), detalleTarea.getCliente(), elemento, descripcion, 
					sesion.getMail(), fechaInicio.getTime(),fechaFin.getTime());
			
			try {
				FacesMessage msg;
				
				if (respuesta.getInt("status") == -9){
					RequestContext.getCurrentInstance().execute("dialogoCambio.hide()");
					salida="irVerDetalle";
					if(archivo!=null){
						new IArchivo().subirArchivoCambioCMDB(archivo,nombreArchivo, sesion.getTokenId(),new Integer(respuesta.getInt("idCambio")));
					}
					archivo=null;
					nombreArchivo="";
					descripcion="";
				
					fechaInicio=null;
					fechaFin = new Date();
				
					msg= new FacesMessage("Cambio agregado correctamente", "");
					
				}else
					msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al agregar el cambio", "");
				
				FacesContext.getCurrentInstance().addMessage(null, msg);
				
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
			FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al agregar el cambio", "La fecha de inicio debe de ser menor que la fecha de fin");
			
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return salida;
}
	
	
	public DetalleTareaBean getDetalleTarea() {
		return detalleTarea;
	}
	public void setDetalleTarea(DetalleTareaBean detalleTarea) {
		this.detalleTarea = detalleTarea;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

}
