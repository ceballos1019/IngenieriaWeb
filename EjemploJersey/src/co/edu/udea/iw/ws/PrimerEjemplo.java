/**
 * 
 */
package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author Andres Ceballos Sanchez - andres.ceballoss@udea.edu.co
 *
 */
@Path("saludo") //Ruta de la url
public class PrimerEjemplo {
	
	@GET  //Método HTTP con el que quiero que me responda esta función
	@Produces(MediaType.TEXT_HTML)  //Que va a entregar? texto, json, xml
	public String saludar() {
		return "Buenas tardes";		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("2")
	public String saludar2() {
		return "Chao papá";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("3")
	/*Pedir parametros utilizando la URL @QueryParam*/
	public String saludar3(@QueryParam("a") String nombre) {
		return "Buenas " + nombre;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("4/{a}")
	/*Pedir parametros utilizando @PathParam*/
	public String saludar4(@PathParam("a") String nombre) {
		return "Mira como corro papo " + nombre;
	}
	
	
}
