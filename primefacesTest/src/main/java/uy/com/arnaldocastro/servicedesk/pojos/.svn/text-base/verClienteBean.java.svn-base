package uy.com.arnaldocastro.servicedesk.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.primefaces.event.SelectEvent;

import uy.com.arnaldocastro.servicedesk.serviciosweb.ICliente;
import uy.com.arnaldocastro.servicedesk.serviciosweb.IGrupo;

public class verClienteBean {

	private String nombreCliente = "";
	private String nombreContacto = "";
	private String emailContacto = "";
	private String telefonoContacto = "";
	private String direccionCliente = "";
	private String grupo = "";

	private String comentarios = "";

	private String SLAAlta;
	private String SLABaja;
	private String SLAMedia;

	private String alertaAlta;
	private String alertaBaja;
	private String alertaMedia;

	private int SLAAlta_tipo = 2;
	private int SLABaja_tipo = 2;
	private int SLAMedia_tipo = 2;

	private int alertaAlta_tipo = 2;
	private int alertaBaja_tipo = 2;
	private int alertaMedia_tipo = 2;
	
	private String darSLAAlta_tipo = "";
	private String darSLABaja_tipo = "";
	private String darSLAMedia_tipo = "";

	private String daralertaAlta_tipo = "  vacio";
	private String daralertaBaja_tipo = "  vacio";
	private String daralertaMedia_tipo = "  vacio";

	List<String> listaClientes;

	private SesionBean sesion;

	public SesionBean getSesion() {
		return sesion;
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getSLAAlta() {
		return SLAAlta;
	}

	public void setSLAAlta(String sLAAlta) {
		SLAAlta = sLAAlta;
	}

	public String getSLABaja() {
		return SLABaja;
	}

	public void setSLABaja(String sLABaja) {
		SLABaja = sLABaja;
	}

	public String getDarSLAAlta_tipo() {
		return darSLAAlta_tipo;
	}

	public String getDarSLABaja_tipo() {
		return darSLABaja_tipo;
	}

	public String getDarSLAMedia_tipo() {
		return darSLAMedia_tipo;
	}

	public String getDaralertaAlta_tipo() {
		return daralertaAlta_tipo;
	}

	public String getDaralertaBaja_tipo() {
		return daralertaBaja_tipo;
	}

	public String getDaralertaMedia_tipo() {
		return daralertaMedia_tipo;
	}

	public String getSLAMedia() {
		return SLAMedia;
	}

	public void setSLAMedia(String sLAMedia) {
		SLAMedia = sLAMedia;
	}

	public String getAlertaAlta() {
		return alertaAlta;
	}

	public void setAlertaAlta(String alertaAlta) {
		this.alertaAlta = alertaAlta;
	}

	public String getAlertaBaja() {
		return alertaBaja;
	}

	public void setAlertaBaja(String alertaBaja) {
		this.alertaBaja = alertaBaja;
	}

	public String getAlertaMedia() {
		return alertaMedia;
	}

	public void setAlertaMedia(String alertaMedia) {
		this.alertaMedia = alertaMedia;
	}

	public int getSLAAlta_tipo() {
		return SLAAlta_tipo;
	}

	public int getSLABaja_tipo() {
		return SLABaja_tipo;
	}

	public void setSLABaja_tipo(int sLABaja_tipo) {
		SLABaja_tipo = sLABaja_tipo;
	}

	public int getSLAMedia_tipo() {
		return SLAMedia_tipo;
	}

	public void setSLAMedia_tipo(int sLAMedia_tipo) {
		SLAMedia_tipo = sLAMedia_tipo;
	}

	public int getAlertaAlta_tipo() {
		return alertaAlta_tipo;
	}

	public void setAlertaAlta_tipo(int alertaAlta_tipo) {
		this.alertaAlta_tipo = alertaAlta_tipo;
		if (alertaAlta_tipo == 1)
			this.daralertaAlta_tipo = " Horas.";
		else
			this.daralertaAlta_tipo = " Dias.";
	}

	public int getAlertaBaja_tipo() {
		return alertaBaja_tipo;
	}

	public void setAlertaBaja_tipo(int alertaBaja_tipo) {
		this.alertaBaja_tipo = alertaBaja_tipo;
	}

	public int getAlertaMedia_tipo() {
		return alertaMedia_tipo;
	}

	public void setAlertaMedia_tipo(int alertaMedia_tipo) {
		this.alertaMedia_tipo = alertaMedia_tipo;
	}

	public void setSLAAlta_tipo(int SLAAlta_tipo) {
		this.SLAAlta_tipo = SLAAlta_tipo;	
	}

	public int getSLABaja__tipo() {
		return SLABaja_tipo;
	}

	public void setSLABaja__tipo(int sLABaja__tipo) {
		SLABaja_tipo = sLABaja__tipo;
	}

	public int getSLAMedia__tipo() {
		return SLAMedia_tipo;
	}

	public void setSLAMedia__tipo(int sLAMedia__tipo) {
		SLAMedia_tipo = sLAMedia__tipo;
	}

	public int getAlertaAlta__tipo() {
		return alertaAlta_tipo;
	}

	public void setAlertaAlta__tipo(int alertaAlta__tipo) {
		this.alertaAlta_tipo = alertaAlta__tipo;
	}

	public int getAlertaBaja__tipo() {
		return alertaBaja_tipo;
	}

	public void setAlertaBaja__tipo(int alertaBaja__tipo) {
		this.alertaBaja_tipo = alertaBaja__tipo;
	}

	public int getAlertaMedia__tipo() {
		return alertaMedia_tipo;
	}

	public void setAlertaMedia__tipo(int alertaMedia__tipo) {
		this.alertaMedia_tipo = alertaMedia__tipo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getEmailContacto() {
		return emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public void modificarCliente() {

		/*
		 * int SLAAltaValor = Integer.parseInt(SLAAlta); int SLABajaValor =
		 * Integer.parseInt(SLABaja); int SLAMediaValor =
		 * Integer.parseInt(SLAMedia);
		 * 
		 * int alertaAltaValor = Integer.parseInt(alertaAlta); int
		 * alertaBajaValor = Integer.parseInt(alertaBaja); int alertaMediaValor
		 * = Integer.parseInt(alertaMedia);
		 */
		/*
		int SLAAltaValor = 2;
		int SLABajaValor = 2;
		int SLAMediaValor = 2;

		int alertaAltaValor = 2;
		int alertaBajaValor = 2;
		int alertaMediaValor = 2;
		*/
		if (SLAAlta_tipo == 2)
			SLAAlta = (Integer.parseInt(SLAAlta) * 24)+"";
		if (SLAMedia_tipo == 2)
			SLAMedia = (Integer.parseInt(SLAMedia) * 24)+"";
		if (SLABaja_tipo == 2)
			SLABaja = (Integer.parseInt(SLABaja) * 24)+"";

		if (alertaAlta_tipo == 2) {
			alertaAlta = (Integer.parseInt(alertaAlta) *24)+"";
		
		}
		if (alertaBaja_tipo == 2)
			alertaBaja = (Integer.parseInt(alertaBaja)* 24)+"";
		if (alertaMedia_tipo == 2)
			alertaMedia = (Integer.parseInt(alertaMedia)* 24)+"";

		JSONObject respuesta = new ICliente().modificarCliente(
				sesion.getTokenId(), nombreCliente, nombreCliente,
				nombreContacto, emailContacto, telefonoContacto,
				direccionCliente, comentarios, Integer.parseInt(SLAAlta), Integer.parseInt(SLAMedia),
						Integer.parseInt(SLABaja), Integer.parseInt(alertaAlta), Integer.parseInt(alertaMedia),
								Integer.parseInt(alertaBaja)/* ,grupo */);

		/*
		 * @FormParam("nombreViejoCliente") String nombreClienteViejo,
		 * 
		 * @FormParam("nombreCliente") String nombreClienteNuevo,
		 * 
		 * @FormParam("nombreContacto") String nombreContacto,
		 * 
		 * @FormParam("emailContacto") String mailContacto,
		 * 
		 * @FormParam("telefonoContacto") String telefonoContacto,
		 * 
		 * @FormParam("direccionCliente") String direccionCliente,
		 * 
		 * @FormParam("comentario") String comentario,
		 * 
		 * @FormParam("SLAAlta") int SLAAlta,
		 * 
		 * @FormParam("SLAMedia") int SLAMedia,
		 * 
		 * @FormParam("SLABaja") int SLABaja,
		 * 
		 * @FormParam("alertaAlta") int alertaAlta,
		 * 
		 * @FormParam("alertaMedia") int alertaMedia,
		 * 
		 * @FormParam("alertaBaja") int alertaBaja)
		 */
		
		try {
			
			String mensaje = respuesta.getString("mensaje");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(mensaje, null));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setDarSLAAlta_tipo(String darSLAAlta_tipo) {
		this.darSLAAlta_tipo = darSLAAlta_tipo;
		if (darSLAAlta_tipo.equals("Horas"))
			SLAAlta_tipo = 1;
		else
			SLAAlta_tipo = 2;			
	}

	public void setDarSLABaja_tipo(String darSLABaja_tipo) {
		this.darSLABaja_tipo = darSLABaja_tipo;
		if (darSLABaja_tipo.equals("Horas"))
			SLABaja_tipo = 1;
		else
			SLABaja_tipo = 2;	
	}

	public void setDarSLAMedia_tipo(String darSLAMedia_tipo) {
		this.darSLAMedia_tipo = darSLAMedia_tipo;
		if (darSLAMedia_tipo.equals("Horas"))
			SLAMedia_tipo = 1;
		else
			SLAMedia_tipo = 2;
	}

	public void setDaralertaAlta_tipo(String daralertaAlta_tipo) {
		this.daralertaAlta_tipo = daralertaAlta_tipo;
		if (daralertaAlta_tipo.equals("Horas"))
			alertaAlta_tipo = 1;
		else
			alertaAlta_tipo = 2;
	}

	public void setDaralertaBaja_tipo(String daralertaBaja_tipo) {
		this.daralertaBaja_tipo = daralertaBaja_tipo;
		if (daralertaBaja_tipo.equals("Horas"))
			alertaBaja_tipo = 1;
		else
			alertaBaja_tipo = 2;
	}

	public void setDaralertaMedia_tipo(String daralertaMedia_tipo) {
		this.daralertaMedia_tipo = daralertaMedia_tipo;
		if (daralertaMedia_tipo.equals("Horas"))
			alertaMedia_tipo = 1;
		else
			alertaMedia_tipo = 2;
	}

	@PostConstruct
	public void listarClientes() {

		JSONObject respuesta = new ICliente()
				.listarCliente(sesion.getTokenId());
		JSONArray lista = null;

		try {

			lista = respuesta.getJSONArray("lista");
			listaClientes = new ArrayList<String>();

			if (lista != null) {
				int len = lista.length();
				for (int i = 0; i < len; i++) {
					try {
						listaClientes.add(lista.getString(i));
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} else
				listaClientes.clear();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public verClienteBean() {
	}

	public List<String> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<String> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<String> listarGrupos() {

		JSONObject respuesta = new IGrupo().listarGrupos(sesion.getTokenId());
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
					aux.add(lista.getJSONObject(i).getJSONObject("grupo")
							.getString("nombre"));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return aux;
	}

	public void onRowSelect(SelectEvent event) {

		JSONObject respuesta = new ICliente().obtenerCliente(
				sesion.getTokenId(), nombreCliente);
		
		try {

			nombreCliente = respuesta.getJSONObject("cliente").getString(
					"nombre");
			nombreContacto = respuesta.getJSONObject("cliente").getString(
					"nombreContacto");
			emailContacto = respuesta.getJSONObject("cliente").getString(
					"correoContacto");
			telefonoContacto = respuesta.getJSONObject("cliente").getString(
					"telefonos");
			direccionCliente = respuesta.getJSONObject("cliente").getString(
					"direccion");
			// grupo = respuesta.getJSONObject("cliente").getString("grupo");
			comentarios = respuesta.getJSONObject("cliente").getString(
					"descripcion");

			int SA = respuesta.getJSONObject("cliente").getInt("prioridadAlta");
			int SB = respuesta.getJSONObject("cliente").getInt("prioridadBaja");
			int SM = respuesta.getJSONObject("cliente")
					.getInt("prioridadMedia");

			int aA = respuesta.getJSONObject("cliente").getInt("alertaAlta");
			int aB = respuesta.getJSONObject("cliente").getInt("alertaBaja");
			int aM = respuesta.getJSONObject("cliente").getInt("alertaMedia");

			if ((SA % 24) == 0) {
				SLAAlta_tipo = 2;
				SLAAlta = SA / 24 + "";

			} else {
				SLAAlta = SA + "";
				SLAAlta_tipo = 1;
			}
			if ((SB % 24) == 0) {
				SLABaja_tipo = 2;
				SLABaja = SB / 24 + "";
			} else {
				SLABaja = SB + "";
				SLABaja_tipo = 1;
			}
			if ((SM % 24) == 0) {
				SLAMedia_tipo = 2;
				SLAMedia = SM / 24 + "";
			} else {
				SLAMedia = SM + "";
				SLAMedia_tipo = 1;
			}
			/***************************/

			if ((aA % 24) == 0) {
				alertaAlta_tipo = 2;
				alertaAlta = aA / 24 + "";
			} else {
				alertaAlta = aA + "";
				alertaAlta_tipo = 1;
			}
			if ((aB % 24) == 0) {
				alertaBaja_tipo = 2;
				alertaBaja = aB / 24 + "";
			} else {
				alertaBaja = aB + "";
				alertaBaja_tipo = 1;
			}
			if ((aM % 24) == 0) {
				alertaMedia_tipo = 2;
				alertaMedia = aM / 24 + "";
			} else {
				alertaMedia = aM + "";
				alertaMedia_tipo = 1;
			}
			
			if (SLAAlta_tipo == 1)
				darSLAAlta_tipo = "Horas";
			else
				darSLAAlta_tipo = "Dias";
			if (SLABaja_tipo == 1)
				darSLABaja_tipo = "Horas";
			else
				darSLABaja_tipo = "Dias";
			if (SLAMedia_tipo == 1)
				darSLAMedia_tipo = "Horas";
			else
				darSLAMedia_tipo = "Dias";
			/******************/
			if (alertaAlta_tipo == 1)
				daralertaAlta_tipo = "Horas";
			else
				daralertaAlta_tipo = "Dias";
			if (alertaBaja_tipo == 1)
				daralertaBaja_tipo = "Horas";
			else
				daralertaBaja_tipo = "Dias";
			if (alertaMedia_tipo == 1)
				daralertaMedia_tipo = "Horas";
			else
				daralertaMedia_tipo = "Dias";
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean esDiasSLAAlta() {
		if (SLAAlta_tipo == 1)
			return false;
		else
			return true;
	}

	public boolean esDiasSLABaja() {
		if (SLABaja_tipo == 1)
			return false;
		else
			return true;
	}

	public boolean esDiasSLAMedia() {
		if (SLAMedia_tipo == 1)
			return false;
		else
			return true;
	}

	public boolean esDiasAlertaAlta_tipo() {
		if (alertaAlta_tipo == 1)
			return false;
		else
			return true;
	}

	public boolean esDiasAlertaBaja_tipo() {
		if (alertaBaja_tipo == 1)
			return false;
		else
			return true;
	}

	public boolean esDiasAlertaMedia_tipo() {
		if (alertaMedia_tipo == 1)
			return false;
		else
			return true;
	}


}
