package uy.com.arnaldocastro.servicedesk.serviciosweb;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.otros.DireccionConsumo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class ICategoria {
	
	public JSONObject listarCategorias(String token) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);

		JSONObject respuesta = service.path("tarea") // primer parte de la ruta
														// (service)
				.path("listarCategorias") // segunda parte de la ruta (metodo)
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
	
	public JSONObject crearCategoria(String token, String nombre) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombre", nombre);

		JSONObject respuesta = service.path("tarea") // primer parte de la ruta
														// (service)
				.path("altaCategoria") // segunda parte de la ruta (metodo)
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
	
	public JSONObject renombrarCategoria(String token, String nombre, String nuevonombre) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombre", nombre);
		form.add("nuevonombre", nuevonombre);


		JSONObject respuesta = service.path("tarea") // primer parte de la ruta
														// (service)
				.path("renombrarCategoria") // segunda parte de la ruta (metodo)
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
