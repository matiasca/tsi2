
package uy.com.arnaldocastro.servicedesk.pojos;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.otros.Status;
import uy.com.arnaldocastro.servicedesk.serviciosweb.ILogin;


public class LoginBean {

	private String usuario;
	private String contrasena;
	private String mailForReset;
	
	public String getMailForReset() {
		return mailForReset;
	}

	public void setMailForReset(String mailForReset) {
		this.mailForReset = mailForReset;
	}

	private SesionBean sesion;

	public void setSesion(SesionBean sesion) {
		this.sesion = sesion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
		this.mailForReset= usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update(contrasena.getBytes());
        
      //convert the byte to hex format method 1
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
       
		
		
		this.contrasena = sb.toString();
	}

   
    
	public String iniciarSesion() {
	
		String outcome = "";
		try {
			JSONObject respuesta = new ILogin().iniciarSesion(usuario, contrasena);
			
			if (respuesta.getInt("status") == 0){
					
			
				JSONObject persona = respuesta.getJSONObject("persona");
				String token = respuesta.getString("token");
				
				String mail = persona.getString("correo");
				String tipoUsuario = persona.getString("tipo");
				
				boolean nuevoUsuario = persona.getBoolean("nuevoUsuario");
				sesion.setNuevoUsuario(nuevoUsuario);
				sesion.setTokenId(token);
				sesion.setMail(mail);
				sesion.setTipoUsuario(tipoUsuario);
				sesion.setLogueado(true);

				sesion.setNombre(persona.getString("nombre") + " " + persona.getString("apellido"));
				System.out.println("************************************token "+token);

				if (tipoUsuario.equals("Usuario"))
					outcome = "homeUsuario";
				else
					outcome = "homeTecnico";
				
			}else{
				String mensaje = respuesta.getString("mensaje");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensaje,null));
				outcome = "login";
				contrasena = "";
			}
		} catch (JSONException e) {
			
			
		}
		
		
			
		return outcome;

	}
	
	public void resetearPassword(){
			JSONObject respuesta = new ILogin().resetearContrasenia(mailForReset);
			try {
				if (respuesta.getInt("status") != 2)
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(respuesta.getString("mensaje"),null));
			
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public String cerrarSesion() {
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		JSONObject respuesta = new ILogin().cerrarSesion(sesion.getTokenId());
		context.getExternalContext().getSessionMap().remove("#{sesionBean}"); 
		
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			    .getExternalContext().getSession(true);
			    session.removeAttribute("sesionBean");
		
		try {
			String mensaje = respuesta.getString("mensaje");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensaje,null));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cerrarSesion";

	}

	
	
}