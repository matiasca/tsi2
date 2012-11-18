package uy.com.arnaldocastro.servicedesk.serviciosweb;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.otros.DireccionConsumo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class ICMDB {
	
	public JSONObject agregarCambioElemento(String token,String nombreCliente, String codigo,String descripcion,
			String responsable, Long fechaInicio, Long fechaFin) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);
		form.add("codigo", codigo);
		form.add("descripcion", descripcion);
		form.add("responsable", responsable);
		form.add("fechaInicio", fechaInicio);
		form.add("fechaFin", fechaFin);
		

		JSONObject respuesta = service.path("cliente") // primer parte de la ruta
														// (service)
				.path("agregarCambioElementoCMDB") // segunda parte de la ruta (metodo)
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

	public JSONObject listarElementos(String token,String nombreCliente) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);

		JSONObject respuesta = service.path("cliente") // primer parte de la ruta
														// (service)
				.path("listarElementoCMDB") // segunda parte de la ruta (metodo)
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
	
	public JSONObject verDetalleElemento(String token,String nombreCliente, String codigo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);
		form.add("codigo", codigo);

		JSONObject respuesta = service.path("cliente") // primer parte de la ruta
														// (service)
				.path("verDetalleElementoCMDB") // segunda parte de la ruta (metodo)
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
	
	public JSONObject crearElemento(String token,String nombreCliente, String codigo, String descripcion, String ubicacion) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);
		form.add("codigo", codigo);
		form.add("descripcion", descripcion);
		form.add("ubicacion", ubicacion);

		JSONObject respuesta = service.path("cliente") // primer parte de la ruta
														// (service)
				.path("crearElementoCMDB") // segunda parte de la ruta (metodo)
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
	
	public JSONObject modificarElemento(String token,String nombreCliente, String codigo, String descripcion, String ubicacion) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);
		form.add("codigo", codigo);
		form.add("descripcion", descripcion);
		form.add("ubicacion", ubicacion);

		JSONObject respuesta = service.path("cliente") // primer parte de la ruta
														// (service)
				.path("modificarElementoCMDB") // segunda parte de la ruta (metodo)
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
	
	public JSONObject eliminarElemento(String token,String nombreCliente, String codigo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);
		form.add("codigo", codigo);

		JSONObject respuesta = service.path("cliente") // primer parte de la ruta
														// (service)
				.path("bajaElementoCMDB") // segunda parte de la ruta (metodo)
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
