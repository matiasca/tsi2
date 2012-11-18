package uy.com.arnaldocastro.servicedesk.serviciosweb;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.otros.DireccionConsumo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class ITarea {

	public JSONObject crearTarea(String token, String usuarioCreador,
			String usuario, String asunto, int prioridad, String descripcion,
			String cliente, String tipo, String clasificacion, String grupo,
			String responsable, int min, int hora, int dia, int mes, int anio) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL

		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("usuarioCreador", usuarioCreador);
		form.add("usuario", usuario);
		form.add("asunto", asunto);
		form.add("prioridad", prioridad);
		form.add("descripcion", descripcion);
		form.add("cliente", cliente);
		form.add("tipo", tipo);
		form.add("clasificacion", clasificacion);
		form.add("grupo", grupo);
		form.add("responsable", responsable);
		form.add("min", min);
		form.add("hora", hora);
		form.add("dia", dia);
		form.add("mes", mes);
		form.add("anio", anio);

		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("registrarTarea") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);

		return respuesta;
	}

	public JSONObject listarTareas(String token, String usuarioCreador,
			String usuario, String prioridad, String cliente, String tipo,
			String categoria, String responsable, String estado,
			String fechaInicio, String fechaFin, String grupo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL

		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("usuarioCreador", usuarioCreador);
		form.add("usuario", usuario);
		form.add("prioridad", prioridad);
		form.add("cliente", cliente);
		form.add("tipo", tipo);
		form.add("responsable", responsable);
		form.add("categoria", categoria);
		form.add("estado", estado);
		form.add("grupo", grupo);
		form.add("fechaInicio", fechaInicio);
		form.add("fechaFin", fechaFin);

		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("listarTareas") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);
		try {
			JSONArray lista = respuesta.getJSONArray("lista");
	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}

	public JSONObject verDetalleTarea(String token, int id) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL

		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();

		form.add("token", token);
		form.add("id", id);

		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("verDetalleTarea") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);

		return respuesta;
	}
	
	public JSONObject cancelarIncidentePorUsuarioFinal(String token, int id) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL

		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();

		form.add("token", token);
		form.add("id", id);

		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("cancelarIncidentePorUsuarioFinal") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON (cancelarIncidentePorUsuarioFinal): " + respuesta);

		return respuesta;
	}

	public JSONObject modificarTarea(String token, Integer idTarea,
			int prioridad, String tipo, String clasificacion,
			String responsable, String estado, String grupo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("id", idTarea);
		form.add("prioridad", prioridad);
		form.add("tipo", tipo);
		form.add("responsable", responsable);
		form.add("clasificacion", clasificacion);
		form.add("estado", estado);
		form.add("nombreGrupo", grupo);

		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("modificarTarea") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);

		return respuesta;
	}
	
	public JSONObject finalizarTarea(String token, int id, Long fechainicio, Long fechafin, String descripcionSolucion) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL

		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();

		form.add("token", token);
		form.add("id", id);
		form.add("fechainicio", fechainicio);
		form.add("fechafin", fechafin);
		form.add("descripcionSolucion", descripcionSolucion);

		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("finalizarTarea") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);

		return respuesta;
	}
	
	
	public JSONObject buscarTarea(String token, String cadena) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL

		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();

		form.add("token", token);
		
		form.add("cadena", cadena);

		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("listarTareasBusqueda") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);

		return respuesta;
	}
}
