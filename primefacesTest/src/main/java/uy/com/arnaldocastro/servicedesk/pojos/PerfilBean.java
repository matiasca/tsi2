package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

@SuppressWarnings("serial")
public class PerfilBean implements Serializable {

	private String nombre;
	private String mail;

	private String apellido;
	private String telefono;
	private String interno;
	private String contrasena = "";
	private SesionBean sesion;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
		sesion.setMail(mail);
	}

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getInterno() {
		return interno;
	}

	public void setInterno(String interno) {
		this.interno = interno;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		
		if (!contrasena.equals("")) {
			MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			md.update(contrasena.getBytes());

			// convert the byte to hex format method 1
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			this.contrasena = sb.toString();
		}else{
			this.contrasena = "";		
		
		}
	}

	@PostConstruct
	public void cargarPerfil() {

		JSONObject respuesta = new IUsuario().detallesPersona(sesion
				.getTokenId());

		try {
			JSONObject ob = respuesta.getJSONObject("detallesPersona");
			nombre = ob.getString("nombre");
			apellido = ob.getString("apellido");
			telefono = ob.getString("telefono");
			interno = ob.getString("interno");
			mail = sesion.getMail();

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String modificarPerfil() {

		JSONObject respuesta = new IUsuario().registrarUsuario(
				sesion.getTokenId(), mail, nombre, apellido, telefono, interno,
				contrasena);

		
		
		String res = "";
		String mensaje;
		try {
			if (respuesta.getInt("status") == 2)
				sesion.setMail(mail);

			String tipoUsuario = sesion.getTipoUsuario();
			sesion.setNombre(nombre+" "+apellido);

			if ((respuesta.getInt("status") == 2)
					&& (tipoUsuario.equals("Administrador")
							|| tipoUsuario.equals("SuperAdministrador") || tipoUsuario
								.equals("Tecnico")))
				res = "homeTecnico";
			else if (respuesta.getInt("status") == 2)
				res = "homeUsuario";
			else
				res = "";

			mensaje = respuesta.getString("Perfil modificado.");
			FacesMessage msg = new FacesMessage(mensaje, "");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public SesionBean getSesion() {
		return sesion;
	}

}
