package uy.com.arnaldocastro.servicedesk.serviciosweb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import uy.com.arnaldocastro.servicedesk.otros.DireccionConsumo;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

public class IUsuario {
	
	
	public JSONObject crearUsuario(String token,String cliente, String email) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreCliente", cliente);
		form.add("mail", email);

		
		JSONObject respuesta = service.path("usuarioCliente") // primer parte de la ruta(service)
						.path("alta") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;
	}
	
	public JSONObject crearTecnico(String token,String email, String grupo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String tipo = "Tecnico";
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("id", email);
		form.add("tipoTecnico", tipo);
		form.add("nombreGrupo", grupo);
				
		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta(service)
						.path("altaTecnicoAdmin") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;
		
		
	}
	
	public JSONObject bajaTecnico(String token,String mailTecnico) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String tipo = "Tecnico";
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("mailTecnico", mailTecnico);
		
				
		JSONObject respuesta = service.path("persona") // primer parte de la ruta(service)
						.path("bajaTecnico") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;	
		
	}
	
	public JSONObject bajaUsuarioCliente(String token,String mailUsuario) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String tipo = "Tecnico";
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("mailUsuario", mailUsuario);
		
				
		JSONObject respuesta = service.path("usuarioCliente") // primer parte de la ruta(service)
						.path("bajaUsuarioCliente") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;	
		
	}
	
	public JSONObject bajaAdministrador(String token,String mailAdministrador) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String tipo = "Tecnico";
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("mailAdministrador", mailAdministrador);
		
				
		JSONObject respuesta = service.path("persona") // primer parte de la ruta(service)
						.path("bajaAdministrador") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;	
		
	}
	

	
	
	
	public JSONObject detallesPersona(String token) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		
				
		JSONObject respuesta = service.path("persona") // primer parte de la ruta(service)
						.path("detallesPersona") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;	
	}
	
	
	
	public JSONObject crearAdmin(String token,String email, String grupo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		String tipo = "Administrador";
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("id", email);
		form.add("tipoTecnico", tipo);
		form.add("nombreGrupo", grupo);
				
		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta(service)
						.path("altaTecnicoAdmin") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;
	}
	
	
	
	public JSONObject listarUsuarios(String token,String cliente) {

		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombre", cliente);
		JSONObject respuesta = service.path("usuarioCliente") // primer parte de la ruta(service)
						.path("listarUsuariosCliente") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;


	}

	public JSONObject listarTecnicos(String token) {
	
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta(service)
						.path("listarTecnicos") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON listarTecnicos: " + respuesta);
		return respuesta;
	
	
	}
	
public JSONObject listarAdministradores(String token) {
	
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta(service)
						.path("listarAdministradores") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON listarTecnicos: " + respuesta);
		return respuesta;
	
	
	}
	
	public JSONObject listarTecnicosAdministradoresSuper(String token) {
	
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);

		JSONObject respuesta = service.path("tecnico") // primer parte de la ruta(service)
						.path("listarTecnicosAdministradoresSuper") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;
	
	
	}
	
	public JSONObject registrarUsuario(String token,String correo,String nombre, String apellido, String telefono, String interno, String contrasena) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreNuevo", nombre);
		form.add("apellido", apellido);
		form.add("telefonoContacto", telefono);
		form.add("interno", interno);
		form.add("contrasena", contrasena);
		form.add("correoNuevo", correo);

	
		
		
		JSONObject respuesta = service.path("persona") // primer parte de la ruta(service)
						.path("modificar") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;
	}
	
	/*public JSONObject modificarPersona(String token,String correo,String nombre, String apellido, String telefono, String interno, String contrasena) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		
		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri("http://"+ DireccionConsumo.getInstance().direccionIP() +":8080/resttest").build());
		
		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("nombreNuevo", nombre);
		form.add("apellido", apellido);
		form.add("telefonoContacto", telefono);
		form.add("interno", interno);
		form.add("contrasena", contrasena);
		form.add("correoNuevo", correo);		
		
		JSONObject respuesta = service.path("persona") // primer parte de la ruta(service)
						.path("modificar") // segunda parte de la ruta (metodo)
						.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE) // tipo
						.accept(MediaType.APPLICATION_JSON) // formato de la respuesta
						.post(JSONObject.class, form); // metodo y parametros (en este caso POST
														// y el formulario que creamos antes)
		
		System.out.println("Respuesta JSON: " + respuesta);
		return respuesta;
	}*/
}
