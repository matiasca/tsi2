package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.sun.jersey.core.util.Base64;

import uy.com.arnaldocastro.servicedesk.otros.FilaTablaHistorial;
import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IArchivo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICategoria;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ITarea;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

public class DetalleTareaBean {

	private FilaTablaHistorial movimiento;
	private int idMovimiento;
	private int prio;
	private String cliente;
	private String usuario;
	private String tipo;
	private String prioridad;
	private String categoria;
	private String grupo;
	private String responsable;
	private String estado;
	private String asunto;
	private String descripcion;
	private String fecha;
	private List<FilaTablaHistorial> historial;
	private boolean tieneArchivo = false;
	private StreamedContent archivo;
	private Integer idArchivo;
	private String tipoMovimiento;
	private boolean estaFinalizada = false;
	private SesionBean sesion;
	private NombreMail resp;
	private String movimientoAutor;
	private String fechaMovimientoInicio;
	private String fechaMovimientoFin;
	private String descripcionMovimiento;
	private boolean tieneArchivoMovimiento = false;
	
	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public DetalleTareaBean() {

	}

	public FilaTablaHistorial getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(FilaTablaHistorial movimiento) {
		this.movimiento = movimiento;
	}

	public boolean isTieneArchivo() {
		return tieneArchivo;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public void setTieneArchivo(boolean tieneArchivo) {
		this.tieneArchivo = tieneArchivo;
	}

	public StreamedContent getArchivo() {
		return archivo;
	}

	public void setArchivo(StreamedContent archivo) {
		this.archivo = archivo;
	}

	public int getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public SesionBean getSesion() {
		return sesion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getMovimientoAutor() {
		return movimientoAutor;
	}

	public void setMovimientoAutor(String movimientoAutor) {
		this.movimientoAutor = movimientoAutor;
	}

	public String getFechaMovimientoInicio() {
		return fechaMovimientoInicio;
	}

	public void setFechaMovimientoInicio(String fechaMovimientoInicio) {
		this.fechaMovimientoInicio = fechaMovimientoInicio;
	}

	public String getFechaMovimientoFin() {
		return fechaMovimientoFin;
	}

	public void setFechaMovimientoFin(String fechaMovimientoFin) {
		this.fechaMovimientoFin = fechaMovimientoFin;
	}

	public String getDescripcionMovimiento() {
		return descripcionMovimiento;
	}

	public void setDescripcionMovimiento(String descripcionMovimiento) {
		this.descripcionMovimiento = descripcionMovimiento;
	}

	public void setIdArchivo(Integer idArchivo) {
		this.idArchivo = idArchivo;
	}

	@PostConstruct
	public void verDetalleTarea() {

		JSONObject respuesta = new ITarea().verDetalleTarea(
				sesion.getTokenId(), sesion.getIdTarea());

		JSONArray lista = null;
		try {
			JSONObject tarea = respuesta.getJSONObject("tarea");
			cliente = tarea.getJSONObject("cliente").getString("nombre");
			usuario = tarea.getJSONObject("usuario").getString("nombre") + " "
					+ tarea.getJSONObject("usuario").getString("apellido");
			tipo = tarea.getString("tipo");
			if (tipo.equals("PedidoDeCambio"))
				tipo = "Pedido de cambio";

			if (tarea.has("categoria")) {
				categoria = tarea.getString("categoria");
				if (categoria.equals(""))
					categoria = "Sin clasificación";
			} else
				categoria = "Sin clasificación";

			if (tarea.has("grupo")) {
				grupo = tarea.getString("grupo");
				if (grupo.equals(""))
					grupo = "Sin asignar";
			} else
				grupo = "Sin asignar";

			if (tarea.has("responsable")) {
				JSONObject resp = tarea.getJSONObject("responsable");
				if (resp.has("nombre"))
					responsable = resp.getString("nombre") + " "
							+ resp.getString("apellido");
				else if (resp.has("mail"))
					responsable = resp.getString("correo");
			} else
				responsable = "Sin asignar";

			estado = tarea.getString("estado");
			if (estado.equals("PENDIENTE"))
				estado = "Pendiente cliente";
			estado = estado.substring(0, 1) + estado.substring(1).toLowerCase();
			if (estado.equals("Finalizada")||estado.equals("Solucionada"))
				estaFinalizada = true;
			
			asunto = tarea.getString("asunto");
			descripcion = tarea.getString("descripcion");
			prio = tarea.getInt("prioridad");
			if (prio == 1)
				prioridad = "Alta";
			else if (prio == 2)
				prioridad = "Media";
			else
				prioridad = "Baja";
			String f = tarea.getString("fechaInicio");
			String dia = f.substring(8, 10);
			String mes = f.substring(5, 7);
			String anio = f.substring(0, 4);
			setFecha(dia + "/" + mes + "/" + anio);			
			
			lista = tarea.getJSONArray("actividades");

			historial = new ArrayList<FilaTablaHistorial>();
			if (lista != null) {

				for (int i = 0; i < lista.length(); i++) {

					JSONObject ob = lista.getJSONObject(i);
					String tipo = ob.getString("tipo");

					FilaTablaHistorial hist = new FilaTablaHistorial();
					hist.setId(ob.getInt("id"));
					hist.setTipo(tipo);
					hist.setAutor(ob.getString("creador"));
					hist.setDescripcion(ob.getString("descripcion"));
					String f2 = null;
					if (ob.has("fechaInicio"))
						f2 = ob.getString("fechaInicio");
					else if (ob.has("fecha"))
						f2 = ob.getString("fecha");
					if (f2 != null) {
						String dia2 = f2.substring(8, 10);
						String mes2 = f2.substring(5, 7);
						String anio2 = f2.substring(0, 4);
						hist.setFecha(dia2 + "/" + mes2 + "/" + anio2);
						String hora2 =  f2.substring(11, 13);
						String min2 =  f2.substring(14, 16);
						hist.setHoraInicio(hora2+":"+min2);
					} else{
						hist.setFecha("");
						hist.setHoraInicio("");
					}
					
					String f3 = null;
					if (ob.has("fechaFin"))
						f3 = ob.getString("fechaFin");
					if (f3 != null) {
						String dia3 = f3.substring(8, 10);
						String mes3 = f3.substring(5, 7);
						String anio3 = f3.substring(0, 4);
						hist.setFechaFin(dia3 + "/" + mes3 + "/" + anio3);
						
						String hora3 =  f3.substring(11, 13);
						String min3 =  f3.substring(14, 16);
						hist.setHoraFin(hora3+":"+min3);
					} else{
						hist.setFechaFin("");
						hist.setHoraFin("");
					}
					if (ob.has("archivos")){
						JSONArray listaArchivos = ob.getJSONArray("archivos");
						if (listaArchivos.length()>0){
							System.out.println("el movimiento tiene archivo");
							hist.setTieneArchivo(true);
							hist.setIdArchivo(listaArchivos.getJSONObject(0).getInt("id"));
						}
					}
					historial.add(hist);
					
				}

			}
			
			JSONArray listaArchivos = tarea.getJSONArray("archivos");
			if (listaArchivos.length()>0){
				tieneArchivo = true;
				idArchivo = listaArchivos.getJSONObject(0).getInt("id");
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void descargarArchivo(){
		
		JSONObject respuesta = new IArchivo().descargarArchivo(sesion.getTokenId(), idArchivo);
		try {
			JSONObject jarchivo = respuesta.getJSONObject("archivo");
			String contenido = jarchivo.getString("contenido");
			String nombre = jarchivo.getString("nombre");
			String[] lNombre = nombre.split("\\.");
			int largo = lNombre.length;
			String extension = lNombre[largo-1];
			String mimeType;
			if (extension.equals("jpg")||extension.equals("jpeg")||extension.equals("png")||extension.equals("gif")||extension.equals("bmp"))
				mimeType = "image/" + extension;
			else
				mimeType = "application/" + extension;
			
			InputStream stream =  new ByteArrayInputStream(Base64.decode(contenido));	
			archivo = new DefaultStreamedContent(stream, mimeType, nombre);
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onRowSelect(SelectEvent getevent) {

			tipoMovimiento = movimiento.getTipo();
			movimientoAutor = movimiento.getAutor();
			fechaMovimientoInicio = movimiento.getFecha() + " " + movimiento.getHoraInicio();
			fechaMovimientoFin = movimiento.getFechaFin() + " " + movimiento.getHoraFin();
			descripcionMovimiento = movimiento.getDescripcion();

	}
	

	
	public List<FilaTablaHistorial> getHistorial() {
		return historial;
	}

	public void setHistorial(List<FilaTablaHistorial> historial) {
		this.historial = historial;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getPrio() {
		return prio;
	}

	public void setPrio(int prio) {
		this.prio = prio;
	}

	public void modificarTarea() {

		String estado2;
		if (estado.equals("Pendiente cliente"))
			estado2 = "PENDIENTE";
		estado2 = estado.toUpperCase();
		
		int prioridad2;
		if (prioridad.equals("Alta"))
			prioridad2 = 1;
		else if(prioridad.equals("Media"))
			prioridad2 = 2;
		else
			prioridad2 = 3;
		
		String tipo2;
		if (tipo.equals("Incidente"))
			tipo2 = "INCIDENTE";
		else
			tipo2 = "PEDIDO_CAMBIO";
	
		
		JSONObject respuesta = new ITarea().modificarTarea(sesion.getTokenId(),
				new Integer(sesion.getIdTarea()), prioridad2, tipo2, categoria,
				responsable, estado2, grupo);
		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2) {
				msg = new FacesMessage("La tarea ha sido modificada", "");
				verDetalleTarea();
			} else
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al modificar la tarea", "");

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String> listarCategorias() {

		JSONObject respuesta = new ICategoria().listarCategorias(sesion.getTokenId());
		JSONArray lista = null;
		try {

			lista = respuesta.getJSONArray("listaCategorias");

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

	public List<String> listarGrupos() {

		JSONObject respuesta = new IGrupo().listarGrupos(sesion.getTokenId());
		JSONArray lista = null;
		List<String> aux = new ArrayList<String>();
		try {

			lista = respuesta.getJSONArray("lista");
			if (lista != null) {
				int len = lista.length();
				for (int i = 0; i < len; i++) {

					aux.add(lista.getJSONObject(i).getJSONObject("grupo")
							.getString("nombre"));

				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return aux;
	}

	public List<NombreMail> listarTecnicosAdministradoresSuper() {
		System.out.println("listarTecnicosAdministradoresSuper");
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

	
	public boolean isTieneArchivoMovimiento() {
		return tieneArchivoMovimiento;
	}

	public void setTieneArchivoMovimiento(boolean tieneArchivoMovimiento) {
		this.tieneArchivoMovimiento = tieneArchivoMovimiento;
	}

	public boolean isEstaFinalizada() {
		return estaFinalizada;
	}

	public void setEstaFinalizada(boolean estaFinalizada) {
		this.estaFinalizada = estaFinalizada;
	}

	public NombreMail getResp() {
		return resp;
	}

	public void setResp(NombreMail resp) {
		this.resp = resp;
	}

}
