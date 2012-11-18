package uy.com.arnaldocastro.servicedesk.serviciosweb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.otros.DireccionConsumo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class ILogin {

	public JSONObject iniciarSesion(String correo, String contrasena) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());

		System.out.println(contrasena);

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("correo", correo);
		form.add("contrasena", contrasena);
		
		JSONObject respuesta = null;
	
		 respuesta = service.path("login") // primer parte de la ruta
														// (service)
				.path("iniciarsesion") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso
												// POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);
		
	
		return respuesta;

	}

	public JSONObject cerrarSesion(String tokenId) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", tokenId);

		JSONObject respuesta = service.path("login") // primer parte de la ruta
														// (service)
				.path("cerrarsesion") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso
												// POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;

	}
	
	
	public JSONObject resetearContrasenia(String mail) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());

		System.out.println(mail);

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("correo", mail);
		
		JSONObject respuesta = null;
	
		 respuesta = service.path("persona") // primer parte de la ruta
														// (service)
				.path("reseteoContrasena") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso
												// POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);
		
	
		return respuesta;

	}

	
	
}
