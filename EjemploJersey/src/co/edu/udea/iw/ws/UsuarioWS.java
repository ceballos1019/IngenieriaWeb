/**
 * 
 */
package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.UsuarioBL;
import co.edu.udea.iw.exception.MyException;

/**
 * Servicio web para autenticar el usuario
 * @author Andrés Ceballos Sánchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
@Path("usuario") //Ruta usualmente es la entidad de negocio
@Component
public class UsuarioWS {
	
	@Autowired
	private UsuarioBL usuarioBL;
	
	/**
	 * 
	 * @param login - login o username del usuario a autenticar
	 * @param password - contraseña del usuario
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String autenticar(@QueryParam("login") String login, @QueryParam("pass") String password) {
		
		String retorno = "";
		
		try {
			usuarioBL.validar(login, password);
		} catch(MyException e) {
			return e.getMessage();
		}
		
		return retorno;
	}
	
}
