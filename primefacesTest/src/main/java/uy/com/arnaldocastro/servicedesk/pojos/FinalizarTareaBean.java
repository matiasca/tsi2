package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.event.FileUploadEvent;

import uy.com.arnaldocastro.servicedesk.otros.NombreMail;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IArchivo;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IMovimiento;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ITarea;

public class FinalizarTareaBean {

	private String solucion;
	private Date fechaInicio;
	private Date fechaFin = new Date();
	private SesionBean sesion;

	private byte[] archivo;
	private String nombreArchivo;

	private String horaFin;
	private String horaInicio;

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

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
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

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void uploadArchivo(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage(event.getFile().getFileName()
				+ " fue subido con éxito.", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		archivo = event.getFile().getContents();
		nombreArchivo = event.getFile().getFileName();

	}

	public void finalizar() {

		JSONObject respuesta = new ITarea().finalizarTarea(sesion.getTokenId(),
				sesion.getIdTarea(), fechaInicio.getTime(), fechaFin.getTime(),
				solucion);

		try {
			FacesMessage msg;
			if (respuesta.getInt("status") == 2
					|| respuesta.getInt("status") == -100) {
				if (archivo != null) {
					new IArchivo().subirArchivoRest(archivo, nombreArchivo,
							sesion.getTokenId(),
							new Integer(sesion.getIdTarea()));
				}
				msg = new FacesMessage("La tarea fue finalizada correctamente",
						"");
				archivo = null;
				nombreArchivo = "";
			} else
				msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error al finalizar la tarea", "");

			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void finalizarMovil() {
		sesion.setIdTarea(4);
		try {
			System.out.println("comenze");
			System.out.printf(horaInicio);
			String[] horaMinSeg = horaInicio.split(":");

			if (Integer.parseInt(horaMinSeg[0]) < 24
					&& Integer.parseInt(horaMinSeg[0]) >= 0
					&& Integer.parseInt(horaMinSeg[1]) < 60
					&& Integer.parseInt(horaMinSeg[1]) >= 0) {
				fechaInicio.setHours(Integer.parseInt(horaMinSeg[0]));
				fechaInicio.setMinutes(Integer.parseInt(horaMinSeg[1]));

				horaMinSeg = horaFin.split(":");
				if (Integer.parseInt(horaMinSeg[0]) < 24
						&& Integer.parseInt(horaMinSeg[0]) >= 0
						&& Integer.parseInt(horaMinSeg[1]) < 60
						&& Integer.parseInt(horaMinSeg[1]) >= 0) {
					fechaFin.setHours(Integer.parseInt(horaMinSeg[0]));
					fechaFin.setMinutes(Integer.parseInt(horaMinSeg[1]));
					System.out.print("//////////////*****llegue");
					if (fechaInicio.before(fechaFin)) {
						JSONObject respuesta = new ITarea().finalizarTarea(
								sesion.getTokenId(), sesion.getIdTarea(),
								fechaInicio.getTime(), fechaFin.getTime(),
								solucion);

						try {
							FacesMessage msg;
							if (respuesta.getInt("status") == 2
									|| respuesta.getInt("status") == -100) {

								msg = new FacesMessage(
										"La tarea fue finalizada correctamente",
										"");
								archivo = null;
								nombreArchivo = "";
							} else
								msg = new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"Error al finalizar la tarea", "");

							FacesContext.getCurrentInstance().addMessage(null,
									msg);

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {

						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"La fecha de inicio debe de ser menor que la fecha de fin",
								"La fecha de inicio debe de ser menor que la fecha de fin");

						FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				} else {
					FacesMessage msg = new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"No es una hora de fin valida.",
							"No es una hora de fin valida.");
					FacesContext.getCurrentInstance().addMessage(null, msg);

				}
			} else {
				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"No es una hora de inicio valida.",
						"No es una hora de inicio valida.");
				FacesContext.getCurrentInstance().addMessage(null, msg);

			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"La hora debe tener el formato 23:52",
					"La hora debe tener el formato 23:52");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	
	
}
