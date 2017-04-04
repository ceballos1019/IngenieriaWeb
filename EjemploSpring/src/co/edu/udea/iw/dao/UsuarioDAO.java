/**
 * 
 */
package co.edu.udea.iw.dao;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author andres.ceballoss
 * @version 1.0
 */
public interface UsuarioDAO {
	
	/**
	 * 
	 * @param login
	 * @return un usuario dada la clave
	 */
	public Usuario obtener(String login) throws MyException;

}
