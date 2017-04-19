package co.edu.udea.iw.bl;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.util.encode.Cifrado;

/**
 * Se definen metodos que garantizan la lógica del negocio en las operaciones de la base de datos relacionadas con el Usuario
 * @author Andres Ceballos Sanchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
public class UsuarioBL {
	
	/* DAO del usuario que es inyectado por Spring*/
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
	
	/**
	 * Verifica si el usuario y contraseña ingresados son válidos
	 * @param login login del usuario
	 * @param password contraseña del usuario
	 * @return si el usuario existe y la contraseña es correcta, retorna True
	 * @throws MyException ocurre cuando el usuario no existe o cuando la contraseña es incorrecta
	 */
	public Boolean validar(String login, String password) throws MyException {
		
		Usuario usuario = null;
		Cifrado cifrado = null;
		
		/*Validar que no sean vacios los campos ingresados*/
		if(login.isEmpty() || login == null) {
			throw new MyException("El login no puede estar vacio");
		}
		
		if(password.isEmpty() || password == null) {
			throw new MyException("La contraseña no puede estar vacia");
		}
		
		usuario = usuarioDAO.obtener(login); 
		
		/*Verificar que el usuario exista en la base de datos*/
		if(usuario == null) {
			throw new MyException("El usuario o la contraseña es incorrecta");
		}
		
		cifrado = new Cifrado();
		
		/*Validar que la contraseña ingresada corresponda con la contraseña en la base de datos*/ 
		if(!cifrado.encrypt(password).equals(usuario.getContrasena())) {
			throw new MyException("El usuario o la contraseña es incorrecta");
		}
		
		return Boolean.TRUE; 
	}
}
