package uy.com.arnaldocastro.servicedesk.serviciosweb;

import java.io.File;
import java.io.IOException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import uy.com.arnaldocastro.servicedesk.otros.DireccionConsumo;


public class IArchivo {


	
	public JSONObject subirArchivoRest( byte[] archivo,String nombreArchivo,
			String token, Integer idtarea) throws ParseException, JSONException {

		JSONObject respuesta = null;
		String url = "http://" +  DireccionConsumo.getInstance().direccionIP() + ":8080/resttest/tarea/adjuntarArchivo";
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		ByteArrayBody fileContent;

		try {

			
			
			
			fileContent = new ByteArrayBody(archivo, nombreArchivo);
			MultipartEntity reqEntity = new MultipartEntity();
			reqEntity.addPart("token", new StringBody(token));
			reqEntity.addPart("idtarea", new StringBody(idtarea.toString()));
			reqEntity.addPart("archivo", fileContent);
			httppost.setEntity(reqEntity);

			HttpResponse response;
			response = httpclient.execute(httppost);

			HttpEntity resEntity = response.getEntity();

			respuesta = new JSONObject(EntityUtils.toString(resEntity));

		} catch (IOException e) {

			e.printStackTrace();
		}

		return respuesta;
	}
	
	
	public JSONObject subirArchivoCambioCMDB( byte[] archivo,String nombreArchivo,
			String token, Integer idCambio) throws ParseException, JSONException {

		JSONObject respuesta = null;
		String url = "http://" +  DireccionConsumo.getInstance().direccionIP() + ":8080/resttest/cliente/adjuntarArchivoCMDB";
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(url);
		ByteArrayBody fileContent;

		try {

			
			fileContent = new ByteArrayBody(archivo, nombreArchivo);
			MultipartEntity reqEntity = new MultipartEntity();
			reqEntity.addPart("token", new StringBody(token));
			reqEntity.addPart("idCambio", new StringBody(idCambio.toString()));
			reqEntity.addPart("archivo", fileContent);
			httppost.setEntity(reqEntity);

			HttpResponse response;
			response = httpclient.execute(httppost);

			HttpEntity resEntity = response.getEntity();

			respuesta = new JSONObject(EntityUtils.toString(resEntity));

		} catch (IOException e) {

			e.printStackTrace();
		}

		return respuesta;
	}
	
	
	public JSONObject descargarArchivo(String token,Integer idarchivo) {

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		// seteo URL
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://" + DireccionConsumo.getInstance().direccionIP()
						+ ":8080/resttest").build());

		// creo formulario con parametros del request
		Form form = new Form();
		form.add("token", token);
		form.add("idarchivo", idarchivo);

		JSONObject respuesta = service.path("tarea") // primer parte de la
														// ruta(service)
				.path("/descargarArchivo") // segunda parte de la ruta (metodo)
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
