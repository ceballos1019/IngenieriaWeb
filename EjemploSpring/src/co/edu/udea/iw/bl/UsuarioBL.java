/**
 * 
 */
package co.edu.udea.iw.bl;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author Andres Ceballos Sanchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
public class UsuarioBL {
	
	private UsuarioDAO usuarioDAO;	
	
	/**
	 * @return the usuarioDAO
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}



	/**
	 * @param usuarioDAO the usuarioDAO to set
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public void validar(String login, String password) throws MyException {
		
		if(login.isEmpty() || login == null) {
			throw new MyException("El login no puede estar vacio");
		}
		
		if(password.isEmpty() || password == null) {
			throw new MyException("La contraseña no puede estar vacia");
		}
		
		Usuario usuario = usuarioDAO.obtener(login);
		if(usuario == null) {
			throw new MyException("El usuario o la contraseña es incorrecta");
		}
		
		if(!password.equals(usuario.getContrasena())) {
			throw new MyException("El usuario o la contraseña es incorrecta");
		}
	}
}
