package uy.com.arnaldocastro.servicedesk.serviciosweb;

import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import uy.com.arnaldocastro.servicedesk.otros.DireccionConsumo;

public class IMovimiento {

	public JSONObject crearMovimiento(String token,int idTarea, String descripcion,
			 Long fechaInicio, Long fechaFin) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("id", idTarea);
		form.add("descripcion", descripcion);
		form.add("fechainicio", fechaInicio);
		form.add("fechafin", fechaFin);


		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("agregarMovimientoTarea") // segunda parte de la ruta (metodo)
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
