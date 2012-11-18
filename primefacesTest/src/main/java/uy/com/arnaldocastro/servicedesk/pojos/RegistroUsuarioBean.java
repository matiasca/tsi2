package uy.com.arnaldocastro.servicedesk.pojos;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


import uy.com.arnaldocastro.servicedesk.serviciosweb.IUsuario;

@SuppressWarnings("serial")
public class RegistroUsuarioBean implements Serializable {


	private String nombre;
	private String apellido;

	private String telefono;
	private String interno;
	private String contrasena;
	private SesionBean sesion;
	
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
	
	public void registrarUsuario(ActionEvent ae){
		
		
		try {
			JSONObject respuesta = new IUsuario().registrarUsuario(sesion.getTokenId(),sesion.getMail(), nombre,  apellido,telefono, interno, contrasena) ;

			String status = respuesta.getString("status");
			if (status.equals("2")){
				sesion.setNuevoUsuario(false);
				
			}
			 
			 System.out.println(sesion.isNuevoUsuario());
				
				
			
				String mensaje = respuesta.getString("mensaje");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(mensaje,null));
			
				
			
		} catch (JSONException e) {
			e.printStackTrace();
			System.out.println("ERROR JSOOOOOOOOOOOON");
			
		}
	
	}
	
	
	public String modificarPerfil(){	
		
		return "/modificarPerfil.xhtml";
	}
	
}