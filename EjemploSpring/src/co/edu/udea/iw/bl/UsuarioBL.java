package co.edu.udea.iw.bl;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;
import co.edu.udea.iw.util.encode.Cifrado;

/**
 * Se definen metodos que garantizan la l�gica del negocio en las operaciones de la base de datos relacionadas con el Usuario
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
	 * Verifica si el usuario y contrase�a ingresados son v�lidos
	 * @param login login del usuario
	 * @param password contrase�a del usuario
	 * @throws MyException ocurre cuando el usuario no existe o cuando la contrase�a es incorrecta
	 */
	public void validar(String login, String password) throws MyException {
		
		Usuario usuario = null;
		Cifrado cifrado = null;
		
		/*Validar que no sean vacios los campos ingresados*/
		if(login == null || login.isEmpty()) {
			throw new MyException("El login no puede estar vacio");
		}
		
		if(password == null || password.isEmpty()) {
			throw new MyException("La contrase�a no puede estar vacia");
		}
		
		usuario = usuarioDAO.obtener(login); 
		
		/*Verificar que el usuario exista en la base de datos*/
		if(usuario == null) {
			throw new MyException("El usuario o la contrase�a es incorrecta");
		}
		
		cifrado = new Cifrado();
		
		/*Validar que la contrase�a ingresada corresponda con la contrase�a en la base de datos*/ 
		if(!cifrado.encrypt(password).equals(usuario.getContrasena())) {
			throw new MyException("El usuario o la contrase�a es incorrecta");
		}		
	}
}
