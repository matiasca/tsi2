package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.event.FileUploadEvent;

import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IArchivo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ICategoria;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ITarea;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

public class TareaBean {

	private String asunto;
	private int prioridad = 3;
	private String descripcion;
	private String cliente;
	private String usuario;
	private String tipo = "1";
	private String clasificacion = "";
	private String grupo = "";
	private String responsable = "";
	private int pregunta1 = -1;
	private int pregunta2 = -1;
	private List<NombreMail> listaUsuarios;
	private SesionBean sesion;
	
	private byte[] archivo;
	private String nombreArchivo;




	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public List<NombreMail> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<NombreMail> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public int getPregunta1() {
		return pregunta1;
	}

	public void setPregunta1(int pregunta1) {
		this.pregunta1 = pregunta1;
	}

	public int getPregunta2() {
		return pregunta2;
	}

	public void setPregunta2(int pregunta2) {
		this.pregunta2 = pregunta2;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getClasificacion() {
		return clasificacion;

	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
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



	public void crearTarea(String usuarioCreador) {
		
		System.out.println("crear tarea");
		
		Calendar c = new GregorianCalendar();

		int min = c.get(Calendar.MINUTE);
		int hora = c.get(Calendar.HOUR_OF_DAY);
		int dia = c.get(Calendar.DATE);
		int mes = c.get(Calendar.MONTH) + 1;
		int anio = c.get(Calendar.YEAR);

		JSONObject respuesta = new ITarea().crearTarea(sesion.getTokenId(),
				usuarioCreador, usuario, asunto, prioridad, descripcion,
				cliente, tipo, clasificacion, grupo, responsable, min, hora,
				dia, mes, anio);

		String mensaje;
		try {

			if (respuesta.getInt("status") == 2) {
				System.out.println("Manda la foto");
				if(archivo!=null){
				new IArchivo().subirArchivoRest(archivo,nombreArchivo, sesion.getTokenId(),new Integer(respuesta.getInt("id")));
				
				}
				asunto = "";
				prioridad = 3;
				descripcion = "";
				
				cliente = "";
				
				usuario = "";
				tipo = "1";
				clasificacion = "";
				grupo = "";
				responsable = "";
				pregunta1 = -1;
				pregunta2 = -1;
				listaUsuarios = new ArrayList<NombreMail>();
				archivo=null;
				nombreArchivo="";
			}

			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int determinarPrioridad(int resp1, int resp2) {

		if (resp1 == 2 && resp2 == 2)
			return 1;
		else if ((resp1 == -1 || resp1 == 1) && (resp2 == -1 || resp2 == 1))
			return 3;
		else
			return 2;

	}

	public void crearIncidente(String usuario) {

		Calendar c = new GregorianCalendar();

		int min = c.get(Calendar.MINUTE);
		int hora = c.get(Calendar.HOUR_OF_DAY);
		int dia = c.get(Calendar.DATE);
		int mes = c.get(Calendar.MONTH) + 1;
		int anio = c.get(Calendar.YEAR);

		JSONObject respuesta = new ITarea().crearTarea(sesion.getTokenId(),
				sesion.getMail(), sesion.getMail(), asunto,
				determinarPrioridad(pregunta1, pregunta2), descripcion, "",
				"1", "", "", "", min, hora, dia, mes, anio);

		String mensaje;
		try {

			
			if (respuesta.getInt("status") == 2) {
				System.out.println("Manda la foto");
				if(archivo!=null){
					
					System.out.println("archivo no es vacio");
					JSONObject re =		new IArchivo().subirArchivoRest(archivo,nombreArchivo, sesion.getTokenId(),new Integer(respuesta.getInt("id")));
				
					mensaje = re.getString("mensaje");
					System.out.println(mensaje);
				
				}
				asunto = "";
				descripcion = "";
				pregunta1 = -1;
				pregunta2 = -1;
				
		
				archivo=null;
				nombreArchivo="";
			}
			
			
			mensaje = respuesta.getString("mensaje");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);

			// FacesContext.getCurrentInstance().getExternalContext().redirect("homeUsuario.xhtml");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		

	}

	public String nuevaTarea() {
		return "nuevaTarea2";
	}

	public void listarUsuarios() {

		List<NombreMail> aux = new ArrayList<NombreMail>();
		if (!cliente.equals("")) {

			JSONObject respuesta = new IUsuario().listarUsuarios(
					sesion.getTokenId(), cliente);
			JSONArray lista = null;
			try {

				lista = respuesta.getJSONArray("lista");

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
			listaUsuarios = aux;
		} else
			listaUsuarios.clear();
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

	
	public void uploadArchivo(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Ok! ", event.getFile()
				.getFileName() + " fue subido con éxito.");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		System.out.println("adjunteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeEEEEEEEEELOGOOOOO");
	
		
		archivo=event.getFile().getContents();
		nombreArchivo=event.getFile().getFileName();
	
		
		
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

}