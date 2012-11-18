package uy.com.arnaldocastro.servicedesk.serviciosweb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

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

public class ICliente {

	public JSONObject crearCliente(String token, String nombreCliente,
			String nombreContacto, String emailContacto,
			String telefonoContacto, String direccionCliente,
			String comentario, int SLAAlta, int SLAMedia, int SLABaja,
			int alertaAlta, int alertaMedia, int alertaBaja, String grupo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);
		form.add("nombreContacto", nombreContacto);
		form.add("emailContacto", emailContacto);
		form.add("telefonoContacto", telefonoContacto);
		form.add("direccionCliente", direccionCliente);
		form.add("comentario", comentario);
		form.add("SLAAlta", SLAAlta);
		form.add("SLAMedia", SLAMedia);
		form.add("SLABaja", SLABaja);
		form.add("alertaAlta", alertaAlta);
		form.add("alertaMedia", alertaMedia);
		form.add("alertaBaja", alertaBaja);
		form.add("grupo", grupo);

		JSONObject respuesta = service.path("cliente") // primer parte de la
														// ruta(service)
				.path("alta") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;

	}

	public JSONObject listarCliente(String token) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();

		form.add("token", token);
		JSONObject respuesta = service.path("cliente") // primer parte de la
														// ruta(service)
				.path("listarClientes") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;

	}

	public JSONObject obtenerCliente(String token, String nombreCliente) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);

		JSONObject respuesta = service.path("cliente") // primer parte de la
														// ruta(service)
				.path("obtenerCliente") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;

	}

	public JSONObject modificarCliente(String token, String nombreClienteViejo,
			String nombreClienteNuevo, String nombreContacto,
			String mailContacto, String telefonoContacto,
			String direccionCliente, String comentario, int SLAAlta,
			int SLAMedia, int SLABaja, int alertaAlta, int alertaMedia,
			int alertaBaja) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreViejoCliente", nombreClienteViejo);
		form.add("nombreCliente", nombreClienteNuevo);
		form.add("nombreContacto", nombreContacto);
		form.add("emailContacto", mailContacto);
		form.add("telefonoContacto", telefonoContacto);
		form.add("direccionCliente", direccionCliente);
		form.add("comentario", comentario);
		form.add("SLAAlta", SLAAlta);
		form.add("SLAMedia", SLAMedia);
		form.add("SLABaja", SLABaja);
		form.add("alertaAlta", alertaAlta);
		form.add("alertaMedia", alertaMedia);
		form.add("alertaBaja", alertaBaja);

		JSONObject respuesta = service.path("cliente") // primer parte de la
														// ruta(service)
				.path("modificar") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;

	}

	public JSONObject bajaCliente(String token, String nombreCliente) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String tipo = "Tecnico";
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", nombreCliente);

		JSONObject respuesta = service.path("cliente") // primer parte de la
														// ruta(service)
				.path("bajaCliente") // segunda parte de la ruta (metodo)
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
				.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
				.post(JSONObject.class, form); // metodo y parametros (en este
												// caso POST
												// y el formulario que creamos
												// antes)

		System.out.println("Respuesta JSON (baja Cliente): " + respuesta);
		return respuesta;

	}

}
