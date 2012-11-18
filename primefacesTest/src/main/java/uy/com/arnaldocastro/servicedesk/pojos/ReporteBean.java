package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.sun.jersey.core.util.Base64;

import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICliente;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IReporte;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

public class ReporteBean {

	private String tipo = "REPORTE_TAREAS_POR_CLIENTE";
	private String formato = "XLS";
	private Date fechaInicio = null;
	private Date fechaFin = null;
	private String tecnico;
	private String cliente;
	private String estado;

	private SesionBean sesion;
	
	private StreamedContent file;  

	public StreamedContent getFile() {
		return file;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
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

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<NombreMail> listarTecnicosAdministradoresSuper() {

		JSONObject respuesta = new IUsuario()
				.listarTecnicosAdministradoresSuper(sesion.getTokenId());
		JSONArray lista = null;
		try {

			lista = respuesta.getJSONArray("lista");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<NombreMail> aux = new ArrayList<NombreMail>();
		if (lista != null) {
			int len = lista.length();
			for (int i = 0; i < len; i++) {
				try {
					JSONObject ob = lista.getJSONObject(i);
					NombreMail b = new NombreMail();
					b.setMail(ob.getString("correo"));
					b.setNombre(ob.getString("nombre") + " "
							+ ob.getString("apellido"));
					aux.add(b);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return aux;
	}

	public List<String> listarClientes() {

		JSONObject respuesta = new ICliente()
				.listarCliente(sesion.getTokenId());
		JSONArray lista = null;
		List<String> aux = null;
		try {

			lista = respuesta.getJSONArray("lista");
			aux = new ArrayList<String>();

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
			} else
				aux.clear();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	public void crearReporte() {

		JSONObject filtros = new JSONObject();
		try {
			if (fechaInicio != null)
				filtros.put("fechaInicio", fechaInicio.getTime());
			if (fechaFin != null)
				filtros.put("fechaFin", fechaFin.getTime());
			if (!cliente.isEmpty())
				filtros.put("cliente", cliente);
			if (!tecnico.isEmpty())
				filtros.put("tecnico", tecnico);
			if (!estado.isEmpty())
				filtros.put("estado", estado);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject respuesta = new IReporte().crearReporte(sesion.getTokenId(),
				filtros, tipo, formato);

		String mensaje;
		try {
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			if (respuesta.getInt("status") == 2){
				String archivo = respuesta.getString("archivo");
				InputStream stream =  new ByteArrayInputStream(Base64.decode(archivo));	
				String nombre;
				if (tipo.equals("REPORTE_TAREAS_POR_CLIENTE"))
					nombre = "reporte_tareas_por_cliente";
				else if (tipo.equals("REPORTE_TAREAS_POR_TECNICO"))
					nombre = "reporte_tareas_por_tecnico";
				else
					nombre = "reporte_tareas_generico";
				if (formato.equals("PDF"))
					file = new DefaultStreamedContent(stream, "application/pdf", nombre+".pdf"); 
				else
					file = new DefaultStreamedContent(stream, "application/xls", nombre+".xls");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
