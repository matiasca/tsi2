package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.event.SelectEvent;

import uy.com.arnaldocastro.servicedesk.otros.FilaTablaTarea;
import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICategoria;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICliente;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ITarea;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

public class TablaTareaBean {

	private String usuarioCreador = "";
	private String usuario = "";
	private String cliente = "";
	private String tipo = "";
	private String categoria = "";
	private String responsable = "";
	private String estado = "";
	private Date fechaInicio;
	private Date fechaFin;
	private String prioridad = "";
	private String grupo = "";
	private SesionBean sesion;

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	private List<FilaTablaTarea> listaTareas;
	private FilaTablaTarea tareaSelecionada;

	public FilaTablaTarea getTareaSelecionada() {
		return tareaSelecionada;
	}

	public void setTareaSelecionada(FilaTablaTarea tareaSelecionada) {

		this.tareaSelecionada = tareaSelecionada;
		if (tareaSelecionada != null)
			sesion.setIdTarea(tareaSelecionada.getId());
		else
			sesion.setIdTarea(-1);

	}

	private int idtarea;

	public int getidTarea() {
		return idtarea;
	}

	public TablaTareaBean() {
	}

	public String getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(String usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public List<FilaTablaTarea> getListaTareas() {
		return listaTareas;
	}

	public void setListaTareas(List<FilaTablaTarea> listaTareas) {
		this.listaTareas = listaTareas;
	}

	public void irVerDetalles(SelectEvent event) {

		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("verDetalleTarea.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PostConstruct
	public void listarTareas() {

		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		String fInicio = "";
		if (fechaInicio != null)
			fInicio = formatter.format(fechaInicio);
		String fFin = "";
		if (fechaFin != null)
			fFin = formatter.format(fechaFin);

		JSONObject respuesta = new ITarea().listarTareas(sesion.getTokenId(),
				usuarioCreador, usuario, prioridad, cliente, tipo, categoria,
				responsable, estado, fInicio, fFin, grupo);

		JSONArray lista = null;
		try {

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

					estado = ob.getString("estado");
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
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Collections.reverse(listaTareas);

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

	public List<String> listarCategorias() {

		JSONObject respuesta = new ICategoria().listarCategorias(sesion
				.getTokenId());
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
		} else
			aux.clear();
		return aux;
	}

	public String getGrupo() {
		return grupo;
	}

	public int getIdtarea() {
		return idtarea;
	}

	public void setIdtarea(int idtarea) {
		this.idtarea = idtarea;
	}

	public SesionBean getSesion() {
		return sesion;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Lista todas las tareas de un determinado estado
	 * 
	 * @param estadoString
	 * @return List<FilaTablaTarea> -- Lista de Tareas
	 */
	public List<FilaTablaTarea> listarTareasEstado(String strEstaado) {
		// inicializo parametros
		List<FilaTablaTarea> listaTareasEstado = new ArrayList<FilaTablaTarea>();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		String fInicio = "";
		if (fechaInicio != null)
			fInicio = formatter.format(fechaInicio);
		String fFin = "";
		if (fechaFin != null)
			fFin = formatter.format(fechaFin);

		// obtengo tareas de webService
		JSONObject respuesta = new ITarea().listarTareas(sesion.getTokenId(),
				usuarioCreador, usuario, prioridad, cliente, tipo, categoria,
				responsable, strEstaado, fInicio, fFin, grupo);

		JSONArray lista = null;
		try {
			lista = respuesta.getJSONArray("lista");
			if (lista != null) {
				for (int i = 0; i < lista.length(); i++) {

					JSONObject ob = lista.getJSONObject(i);
					FilaTablaTarea tarea = new FilaTablaTarea();
					tarea.setAsunto(ob.getString("asunto"));
					if (ob.has("cliente"))
						tarea.setCliente(ob.getJSONObject("cliente").getString(
								"nombre"));

					estado = ob.getString("estado");
					estado = estado.substring(0, 1)
							+ estado.substring(1).toLowerCase();
					tarea.setEstado(estado);

					String f = ob.getString("fechaInicio");
					String dia = f.substring(8, 10);
					String mes = f.substring(5, 7);
					String anio = f.substring(0, 4);

					tarea.setFecha(dia + "/" + mes + "/" + anio);

					tarea.setId(ob.getInt("id"));

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
					listaTareasEstado.add(tarea);
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.reverse(listaTareasEstado);
		return listaTareasEstado;
	}

	/**
	 * Retorna lista de tareas pendientes
	 * 
	 * @return
	 */
	public List<FilaTablaTarea> listarTareasPendientes() {
		return listarTareasEstado("PENDIENTE");
	}

	/**
	 * Retorna lista de tareas Finalizadas
	 * 
	 * @return
	 */
	public List<FilaTablaTarea> listarTareasFinalizadas() {
		return listarTareasEstado("FINALIZADA");
	}
}
