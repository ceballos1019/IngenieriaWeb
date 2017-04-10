/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Define los métodos de la capa de accesos a datos para los usuarios del sistema
 * @author Andrés Ceballos Sánchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
public interface UsuarioDAO {
	
	/**
	 * Enrega la lista de usuarios disponibles en la base de datos
	 * @return Lista de usuarios
	 * @throws MyException Cuando hay un error en la consulta 
	 * 
	 */
	public List<Usuario> obtener() throws MyException;
	
	/**
	 * Consulta la información de un usuario dado su login o nombre de usuario
	 * @param login - login o nombre del usuario a consultar
	 * @return DTO con la información del usuario consultado, si el usuario no existe retorna null
	 * @throws MyException si hay un error accediendo a los datos
	 */
	public Usuario obtener(String login) throws MyException;
	
	/**
	 * Crear un usuario en la base de datos
	 * @param usuario - DTO con los datos del usuario a crear
	 * @throws MyException
	 */
	public void guardar(Usuario usuario) throws MyException;

}
