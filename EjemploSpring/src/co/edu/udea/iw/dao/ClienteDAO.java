/**
 * 
 */
package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * Define los métodos para la capa de accesos a datos para los clientes del sistema
 * @author Andrés Ceballos Sánchez - andres.ceballoss@udea.edu.co
 * @version 1.0
 */
public interface ClienteDAO {
	
	/**
	 * Enrega la lista de clientes ordenados por su fecha de creacion
	 * @return Lista de clientes
	 * @throws MyException Cuando hay un error en la consulta 
	 * 
	 */
	public List<Cliente> obtener() throws MyException;
	
	/**
	 * Consulta la información de un cliente dada su cedula
	 * @param cedula - cedula del cliente a consultar
	 * @return DTO con la información del cliente consultado, si el cliente no existe retorna null
	 * @throws MyException si hay un error accediendo a los datos
	 */
	public Cliente obtener(String cedula) throws MyException;
	
	/**
	 * Crear un cliente en la base de datos
	 * @param cliente - DTO con los datos del cliente a crear
	 * @throws MyException
	 */
	public void guardar(Cliente cliente) throws MyException;

}
