import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import com.sun.syndication.feed.synd.SyndEnclosureImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import com.sun.syndication.feed.synd.SyndEntry;

public class main {

	/**
	 * @param args
	 */

	public static String obtenerLugar(int comienzo, String dato) {

		int posI = dato.indexOf("<strong>", comienzo) + 17;

		int posF = dato.indexOf("</strong>", posI) - 1;

		return dato.substring(posI, posF);

	}

	public static String[] obtenerHoras(String dato) {

		String[] res;
		dato = dato.trim();
		System.out.println("HORAS  "+dato);
		res = dato.split(" - ");

		

		return res;

	}

	@SuppressWarnings("deprecation")
	public static String enviarEVENTO(String nombre, String descripcion,
			String direccion, String hora, byte[] foto) {

		if(!hora.isEmpty()){
		Evento e = new Evento();
		e.setIp("localhost");

		e.setDescripcion(descripcion);//descripcion

		if (direccion.equals("Portones Shopping")) {
			e.setDireccion(direccion);
			e.setLatitud(-34882409);
			e.setLongitud(-56083253);
		}

		if (direccion.equals("Montevideo Shopping")) {

			e.setDireccion(direccion);
			e.setLatitud(-34903389);
			e.setLongitud(-56136800);
		}

		if (direccion.equals("Punta Carretas Shopping")) {

			e.setDireccion(direccion);
			e.setLatitud(-34924064);
			e.setLongitud(-56158794);
		}

		e.setImagen(foto);
		Date d = new Date();
		Collection <Categoria> categorias = new ArrayList<Categoria>();
		
		categorias.add(Categoria.Entretenimiento);
		categorias.add(Categoria.Gastronomia);
		e.setCategorias(categorias);
		
		String[] horMin = hora.split(":");

		d.setHours((new Integer(horMin[0])));
		d.setMinutes(new Integer(horMin[1]));
		d.setSeconds(0);
		System.out.println(d.toString());
		e.setFechaInicio(d);//fechaInicio
		Date d2 = new Date();
		
		d2.setHours((new Integer(horMin[0]))+2);
		d2.setMinutes(new Integer(horMin[1]));
		d2.setSeconds(0);
		e.setFechaFin(d2);//fechafin
		
		e.setNombre(nombre);//nombre
		
		return e.enviarEvento();
		}
		else return "error";
	}

	public static void main(String[] args) {

		try {
			// http://www.elpais.com.uy/formatos/rss/index.asp?seccion=espectaculos
			// http://www.orangefeeds.com/scripts/getFeed.php?account=peu&id=cine-cartelera-cinemateca
			// http://www.montevideo.com.uy/anxml.aspx?60
			// http://www.movie.com.uy/rss/
			// http://portal.gub.uy/ServicioIntermedio/SIG?operationtype=1&idfeed=3384
			// http://portal.gub.uy/ServicioIntermedio/SIG?operationtype=1&idfeed=3384
			URL feedUrl = new URL("http://www.movie.com.uy/rss/");

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed feed = input.build(new XmlReader(feedUrl));

			List<SyndEntry> entradas = new ArrayList<SyndEntry>();
			entradas = feed.getEntries();

			// list iterator
			Iterator<SyndEntry> it = entradas.iterator();

			while (it.hasNext()) {
				SyndEntry entrada = it.next();
				
				List<SyndEnclosureImpl> ent= entrada.getEnclosures();
				String url=ent.get(0).getUrl();
				
				//System.out.println(entrada);

				// System.out.println("Titulo: " + entrada.getTitle() );
				String titulo = entrada.getTitle();// TITULO
				System.out.println("TITULO    " + titulo);
				// System.out.println("Descripcion: "
				// + entrada.getDescription().getValue());
				String descr = entrada.getDescription().getValue();
				descr = descr.trim();

				int finDesc = descr.indexOf("<br /><br />", 0);
				String descripcionEnviar = descr.substring(0, finDesc);// DESCRIPCION
				//System.out.println("DESCR ENVIAR    " + descripcionEnviar);
				
				descr = descr.substring(finDesc, descr.length());

				//System.out.println(descr);
				boolean termine = false;
				if (descr.indexOf("<strong>") == -1)
					termine = true;

				while (!termine) {

					// System.out.println("##" + descr+"##");
					String lugar = obtenerLugar(0, descr);

					System.out.println("LUGAR" + lugar);

					descr = descr.substring(descr.indexOf("<br />") + 6);

					String[] horas = obtenerHoras(descr.substring(0,
							descr.indexOf("<br />")));

					
					
					URL u = new URL(url);
	                URLConnection uc = u.openConnection();
	                String contentType = uc.getContentType();
	                int contentLength = uc.getContentLength();
	                InputStream raw = uc.getInputStream();
	                InputStream in = new BufferedInputStream(raw);
	                byte[] data = new byte[contentLength];
	                int bytesRead;
	                int offset = 0;
	                while (offset < contentLength) {
	                    bytesRead = in.read(data, offset, data.length - offset);
	                    if (bytesRead == -1)
	                        break;
	                    offset += bytesRead;
	                }
	                in.close();
	                if (offset != contentLength) {
	                    throw new IOException("Only read " + offset + " bytes; Expected " + contentLength + " bytes");
	                }
//			           System.out.println("///////////////////////////////////////////////");
//			           System.out.println(url);
//	                System.out.println(data.length);
					
					for (int i = 0; i < horas.length; i++){
						
						if(!horas[i].isEmpty())
							System.out.println(enviarEVENTO(titulo, descripcionEnviar, lugar, horas[i],data));
					}
					if (descr.indexOf("<strong>") != -1) {

						descr = descr.substring(descr.indexOf("<strong>"));
						//System.out.println(descr);
					} else
						termine = true;

				}

				System.out.println("      ========================           ");
			}

			//
			// URL u = new URL(image);
			// URLConnection uc = u.openConnection();
			// String contentType = uc.getContentType();
			// int contentLength = uc.getContentLength();
			// InputStream raw = uc.getInputStream();
			// InputStream in = new BufferedInputStream(raw);
			// byte[] data = new byte[contentLength];
			// int bytesRead;
			// int offset = 0;
			// while (offset < contentLength) {
			// bytesRead = in.read(data, offset, data.length - offset);
			// if (bytesRead == -1)
			// break;
			// offset += bytesRead;
			// }
			// in.close();
			// if (offset != contentLength) {
			// throw new IOException("Only read " + offset + " bytes; Expected "
			// + contentLength + " bytes");
			// }
			// String[] tmp = image.split("/");
			// String filename = tmp[tmp.length - 1];
			// FileOutputStream out = new FileOutputStream(filename);
			// out.write(data);
			// out.flush();
			// out.close();

			//
			//
			// Evento e = new Evento();
			// e.setIp("localhost");
			// e.setDescripcion("Lo del gordo, el mejor lugar");
			// e.setDireccion("hipolito yrigoyen 1625, Montevideo, Uruguay");
			// e.setFechaInicio(new Date());
			// e.setNombre("fiesta Lo del gordo");
			// System.out.println(e.enviarEvento());

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}

	}

}
