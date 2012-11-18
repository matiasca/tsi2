package uy.com.arnaldocastro.servicedesk.serviciosweb;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.otros.DireccionConsumo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class IGrupo {

	public JSONObject crearGrupo(String token,String nombre, String admin, List<String> tecnicos) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombre", nombre);
		form.add("correoJefe", admin);
		form.add("corroesTecnicos", tecnicos);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("altaGrupoTecnicos") // segunda parte de la ruta (metodo)
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
	
	
	public JSONObject listarAdministradoresSinGrupo(String token) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("listarAdministradoresSinGrupo") // segunda parte de la ruta (metodo)
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
	
	public JSONObject listarAdministradores(String token) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("listarAdministradores") // segunda parte de la ruta (metodo)
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
	
	public JSONObject listartecnicosSinGrupo(String token) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombre", "");//no es necesario
		
		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("listarTecnicosSinGrupo") // segunda parte de la ruta (metodo)
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
	
	public JSONObject listarGrupos(String token) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("listarGrupos") // segunda parte de la ruta (metodo)
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
	
	public JSONObject listarGruposSinAdministrador(String token) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("listarGruposSinAdministrador") // segunda parte de la ruta (metodo)
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
	
	public JSONObject bajaGrupo(String token, String nombre) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombre", nombre);

		JSONObject respuesta = service.path("tecnico") // primer parte de la
														// ruta(service)
				.path("bajaDeGruposDeTecnicos") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON (baja grupo): " + respuesta);
		return respuesta;

	}
	
	public JSONObject listarMiembrosDeGrupo(String token,String nombreGrupo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombre", nombreGrupo);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("listarMiembrosGrupo") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso
												// POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: (listarMiembrosGrupo) " + respuesta);
		return respuesta;

	}
	
	public JSONObject tecnicosFueraDelGrupo(String token,String nombreGrupo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreGrupo", nombreGrupo);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("tecnicosFueraDelGrupo") // segunda parte de la ruta (metodo)
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
	
	public JSONObject modificiarGrupo(String token,String nombreGrupo, String nombreNuevo,JSONArray correosTecnicos,String correoAdmin) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" +  DireccionConsumo.getInstance().direccionIP()  + ":8080/resttest").build());


		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombre", nombreGrupo);
		form.add("nombreNuevo", nombreNuevo);
		form.add("correosTecnicos", correosTecnicos);
		form.add("correoAdmin", correoAdmin);
		
	

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta
														// (service)
				.path("modificarGrupo") // segunda parte de la ruta (metodo)
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
